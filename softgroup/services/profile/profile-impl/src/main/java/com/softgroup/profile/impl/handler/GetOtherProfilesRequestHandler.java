package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetOtherProfilesRequest;
import com.softgroup.profile.api.message.GetOtherProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetOtherProfilesRequestHandler extends AbstractRequestHandler<GetOtherProfilesRequest,GetOtherProfilesResponse>  implements ProfileRequestHandler {
    public String getName(){
        return "get_other_profiles";
    }

    @Override
    public Class<GetOtherProfilesRequest> getRequestDataClass() {
        return GetOtherProfilesRequest.class;
    }

    public Response<GetOtherProfilesResponse> processRequest(Request<GetOtherProfilesRequest> msg){
        return null;
    }
}
