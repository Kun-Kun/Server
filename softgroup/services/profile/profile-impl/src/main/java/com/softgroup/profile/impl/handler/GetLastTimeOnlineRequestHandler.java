package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetLastTimeOnlineRequest;
import com.softgroup.profile.api.message.GetLastTimeOnlineResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetLastTimeOnlineRequestHandler extends AbstractRequestHandler<GetLastTimeOnlineRequest,GetLastTimeOnlineResponse>  implements ProfileRequestHandler {
    public String getName(){
        return "get_last_time_online";
    }

    @Override
    public Response<GetLastTimeOnlineResponse> handle(Request<?> msg) {
        Response<GetLastTimeOnlineResponse> response = new Response<GetLastTimeOnlineResponse>();
        response.setData(new GetLastTimeOnlineResponse());
        return response;
    }
}
