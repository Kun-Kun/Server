package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetContactProfilesRequest;
import com.softgroup.profile.api.message.GetContactProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;

/**
 * Created by user on 26.02.2017.
 */
public class GetContactProfilesRequestHandler extends AbstractRequestHandler<GetContactProfilesRequest,GetContactProfilesResponse>  implements ProfileRequestHandler {
    public String getName(){
        return "get_contact_profiles";
    }

    @Override
    public Response<GetContactProfilesResponse> handle(Request<?> msg) {
        Response<GetContactProfilesResponse> response = new Response<GetContactProfilesResponse>();
        response.setData(new GetContactProfilesResponse());
        return response;
    }
}
