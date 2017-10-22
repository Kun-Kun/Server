package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseStatusCode;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.messenger.api.dto.DTOCursorRequest;
import com.softgroup.messenger.api.dto.DTOCursorResponse;
import com.softgroup.messenger.api.dto.DTOMessage;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.mapper.MessageMapper;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 26.02.2017.
 */

@Component
public class GetMessagesRequestHandler extends AbstractRequestHandler<GetMessagesRequest,GetMessagesResponse> implements MessengerRequestHandler {

    @Autowired
    private MessengerService service;

    @Autowired
    private MessageMapper messageMapper;

    public String getName(){
        return "get_messages";
    }

    @Override
    public Class<GetMessagesRequest> getRequestDataClass() {
        return GetMessagesRequest.class;
    }

    @Override
    public Response<GetMessagesResponse> processRequest(Request<GetMessagesRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        String conversationId = msg.getData().getConversationId();
        DTOCursorRequest cursorRequest = msg.getData().getCursor();
        if(service.isUserInConversation(userId,conversationId)){
            List<MessageEntity> messageEntityList = service.loadMessages(conversationId,userId,cursorRequest);
            Long lastLoadedIndex=messageEntityList.parallelStream().min(Comparator.comparingLong(MessageEntity::getServerReceiveTime)).map(MessageEntity::getServerReceiveTime).orElse(cursorRequest.getOffset());
            List<DTOMessage> dtoMessages = messageEntityList.parallelStream().map(messageEntity -> {
                DTOMessage dtoMessage = messageMapper.mapMessageDtoFromEntity(messageEntity);
                dtoMessage.setMessageIndex(messageEntity.getServerReceiveTime());
                return dtoMessage;
            }).collect(Collectors.toList());
            Boolean isMoreExist = service.isMoreMessageExist(conversationId,userId,lastLoadedIndex);
            Integer totalUnread = service.getUnreadMessagesCount(conversationId,userId);

            DTOCursorResponse cursorResponse = new DTOCursorResponse();
            cursorResponse.setIsMoreExists(isMoreExist);
            GetMessagesResponse response = new GetMessagesResponse();
            response.setMessages(dtoMessages);
            response.setCursor(cursorResponse);
            response.setTotalUnread(totalUnread);
            return ResponseUtils.createOKResponse(msg,response);
        }else{
            return ResponseUtils.createCustomResponse(msg, ResponseStatusCode.FORBIDDEN,"You are not member of this conversation");
        }
    }
}
