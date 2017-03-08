package com.softgroup.common.impl.router;

/**
 * Created by user on 03.03.2017.
 */

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.CommandTypeRouter;


import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    @Mock
    private CommandTypeRouter authorizationRouter;
    @Mock
    private CommandTypeRouter profileRouter;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<RequestData> authorizationRequestREST;
    private Request<RequestData> profileRequestREST;

    @Before
    public void createRequestResponse(){
        authorizationRequestREST = new Request<RequestData>();
        ActionHeader header = new ActionHeader();
        header.setType("authorization");
        authorizationRequestREST.setHeader(header);

        when(authorizationRouter.getName()).thenReturn("authorization");

        profileRequestREST = new Request<RequestData>();
        ActionHeader header1 = new ActionHeader();
        header1.setType("profile");
        profileRequestREST.setHeader(header1);

        when(profileRouter.getName()).thenReturn("profile");

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
        verify(profileRouter,never()).handle(authorizationRequestREST);
    }

    @Test
    public void traceRouteToProfiles(){
        Response r = router.handle(profileRequestREST);
        verify(profileRouter).handle(profileRequestREST);
        verify(authorizationRouter,never()).handle(profileRequestREST);
    }


}


