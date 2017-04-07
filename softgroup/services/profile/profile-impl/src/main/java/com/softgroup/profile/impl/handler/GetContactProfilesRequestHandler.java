package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetContactProfilesRequest;
import com.softgroup.profile.api.message.GetContactProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetContactProfilesRequestHandler extends AbstractRequestHandler<GetContactProfilesRequest,GetContactProfilesResponse>  implements ProfileRequestHandler {
    public String getName(){
        return "get_contact_profiles";
    }

    @Override
    public Class<GetContactProfilesRequest> getRequestDataClass() {
        return GetContactProfilesRequest.class;
    }

    public Response<GetContactProfilesResponse> processRequest(Request<GetContactProfilesRequest> msg){
        return null;
    }
}
