package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.ContactsSyncRequest;
import com.softgroup.profile.api.message.ContactsSyncResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class ContactsSyncRequestHandler extends AbstractRequestHandler<ContactsSyncRequest,ContactsSyncResponse> implements ProfileRequestHandler{
    public String getName(){
        return "contacts_sync";
    }
    @Override
    public Class<ContactsSyncRequest> getRequestDataClass() {
        return ContactsSyncRequest.class;
    }
    public Response<ContactsSyncResponse> processRequest(Request<ContactsSyncRequest> msg){
       	        return null;
    }
}
