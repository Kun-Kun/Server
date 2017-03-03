package com.softgroup.common.impl.router;

/**
 * Created by user on 03.03.2017.
 */

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.impl.router.AuthorizationRouter;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.CommandTypeRouter;

import com.softgroup.profile.api.message.GetContactProfilesRequest;

import com.softgroup.profile.impl.router.ProfileRouter;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Spy;


/**
 * Created by user on 03.03.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CommonTypeRouterUnitTest {

    @InjectMocks
    private CommonTypeRouter router;

    @Spy
    private ArrayList<CommandTypeRouter> handlers;
    @Spy
    private HashMap<String,CommandTypeRouter> handlersMap;
    @Spy
    private AuthorizationRouter authorizationRouter;
    @Spy
    private ProfileRouter profileRouter;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<RegisterRequest> authorizationRequestREST;
    private Request<GetContactProfilesRequest> profileRequestREST;

    @Before
    public void createRequestResponse(){
        authorizationRequestREST = new Request<RegisterRequest>();
        ActionHeader header = new ActionHeader();
        header.setType("authorization");
        RegisterRequest registerEntry = new RegisterRequest();
        authorizationRequestREST.setHeader(header);
        authorizationRequestREST.setData(registerEntry);

        profileRequestREST = new Request<GetContactProfilesRequest>();
        ActionHeader header1 = new ActionHeader();
        header1.setType("profile");
        GetContactProfilesRequest getContactProfilesEntry = new GetContactProfilesRequest();
        profileRequestREST.setHeader(header1);
        profileRequestREST.setData(getContactProfilesEntry);

        handlers.add(authorizationRouter);
        handlers.add(profileRouter);

        for(CommandTypeRouter h:handlers){
            handlersMap.put(h.getName(),h);
        }

    }

    @Test
    public void traceRouteToAuth(){
        Response r = router.handle(authorizationRequestREST);

        verify(authorizationRouter).handle(authorizationRequestREST);
        verify(authorizationRouter,never()).handle(profileRequestREST);
    }

    @Test
    public void traceRouteToProfiles(){
        Response r = router.handle(profileRequestREST);
        verify(profileRouter).handle(profileRequestREST);
        verify(profileRouter,never()).handle(authorizationRequestREST);
    }


}


