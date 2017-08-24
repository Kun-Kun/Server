package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseStatusCode;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.messenger.api.message.DeleteConversationRequest;
import com.softgroup.messenger.api.message.DeleteConversationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class DeleteConversationRequestHandler extends AbstractRequestHandler<DeleteConversationRequest,DeleteConversationResponse> implements MessengerRequestHandler {

    @Autowired
    private MessengerService messengerService;

    public String getName(){
        return "delete_conversation";
    }

    @Override
    public Class<DeleteConversationRequest> getRequestDataClass() {
       return DeleteConversationRequest.class;
    }

    @Override
    public Response<DeleteConversationResponse> processRequest(Request<DeleteConversationRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        String conversationId = msg.getData().getConversationId();

        ConversationEntity conversationToDelete = messengerService.getConversationById(conversationId);
        if(messengerService.isUserAdmin(userId,conversationToDelete)){
            messengerService.deleteConversation(conversationId);
            messengerService.deleteUsersFromConversation(conversationId);
            return ResponseUtils.createOKResponse(msg, new DeleteConversationResponse());
        }else{
            return  ResponseUtils.createCustomResponse(msg, ResponseStatusCode.BAD_REQUEST,"You are not the administrator of this conversation");
        }
    }

}
