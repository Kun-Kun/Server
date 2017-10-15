package com.softgroup.server.socket.socket;

import com.softgroup.common.exceptions.MapperException;
import com.softgroup.common.exceptions.TokenException;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.utilites.ResponseStatusCode;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.server.socket.filter.SocketRouterHandler;
import com.softgroup.server.socket.service.WebSocketSessionHolderServiceImpl;
import com.softgroup.server.tools.service.ControllerTool;
import com.softgroup.token.api.JwtUserIdentifierExtended;
import com.softgroup.token.api.TokenType;
import com.softgroup.token.impl.TokenService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;


@Component
public class SocketHandler extends TextWebSocketHandler {

    private Log log = LogFactory.getLog(SocketHandler.class);

    @Autowired
    private WebSocketSessionHolderServiceImpl webSocketSessionHolderService;

    @Autowired
    private ControllerTool controllerTool;

    @Autowired
    private SocketRouterHandler socketRouterHandler;

    @Autowired
    private TokenService tokenService;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)  {
        String textMessage = message.getPayload();
        try {
            try {
                Map<String, Object> values = controllerTool.parseMapFromJson(textMessage);
                Object token = values.get("token");
                Object data = values.get("data");
                if (token != null) {
                    processToken(token,session);
                }
                if (data != null) {
                    processMessage(data,session);
                }
            }catch (MapperException me){
                log.error("Can't map json",me);
                session.sendMessage(new TextMessage(controllerTool.dataToString(ResponseUtils.createBadRequestResponse(new Request<>()))));
            }
        } catch (IOException ioe) {
            log.error("Can't send message to socket",ioe);
            ioe.printStackTrace();
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        webSocketSessionHolderService.registerSession(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        webSocketSessionHolderService.invalidateAll(session);
    }

    private void processToken(Object token, WebSocketSession session) throws IOException{
        try {
            String stringToken = (String) (token);
            JwtUserIdentifierExtended jwtUserIdentifierExtended = tokenService.getUserIdentifier(stringToken, TokenType.SHORT_TERM);
            webSocketSessionHolderService.registerUser(session, jwtUserIdentifierExtended);
        } catch (TokenException exception) {
            session.sendMessage(new TextMessage(controllerTool.dataToString(ResponseUtils.createCustomResponse(new Request<>(), ResponseStatusCode.NOT_ACCEPTABLE,"Token is invalid"))));
            log.error("An error occurred. Token is invalid. ", exception);
        } catch (IllegalArgumentException exception){
            session.sendMessage(new TextMessage(controllerTool.dataToString(ResponseUtils.createCustomResponse(new Request<>(), ResponseStatusCode.NOT_ACCEPTABLE,"Token is empty"))));
            log.error("An error occurred. Token is invalid. ", exception);
        } catch (ClassCastException e){
            session.sendMessage(new TextMessage(controllerTool.dataToString(ResponseUtils.createCustomResponse(new Request<>(), ResponseStatusCode.NOT_ACCEPTABLE,"Token must be string"))));
            log.error("An error occurred. Token is invalid. ", e);

        }
    }

    private void processMessage(Object data, WebSocketSession session) throws IOException{
        Request request = controllerTool.parseRequestFromJson(controllerTool.dataToString(data));
        JwtUserIdentifierExtended userIdentifier = webSocketSessionHolderService.getUser(session);
        userIdentifier = webSocketSessionHolderService.validateSessionRegistration(session,userIdentifier);
        Request requestWithRoutingData = controllerTool.setRoutingData(request, userIdentifier);
        Response response = socketRouterHandler.handle(requestWithRoutingData);
        String textResponse = controllerTool.dataToString(response);
        session.sendMessage(new TextMessage(textResponse));
    }
}