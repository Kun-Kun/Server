package com.softgroup.authorization.impl.router;

import com.softgroup.authorization.api.message.*;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.impl.handler.LoginRequestHandler;
import com.softgroup.authorization.impl.handler.RegisterRequestHandler;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by user on 26.02.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorizationRouterUnitTest {

    @InjectMocks
    private AuthorizationRouter router;

    @Spy
    private ArrayList<AuthorizationRequestHandler> handlers;
    @Spy
    private HashMap<String,AuthorizationRequestHandler> handlersMap;
    @Mock
    private AuthorizationRequestHandler loginHandler;
    @Mock
    private AuthorizationRequestHandler registerHandler;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<LoginRequest> loginRequestREST;
    private Request<RegisterRequest> registerRequestREST;
    private Response loginResponse;
    private Response registerResponse;

    @Before
    public void createRequestResponse(){
        loginRequestREST = new Request<LoginRequest>();
        ActionHeader header = new ActionHeader();
        header.setCommand("login");
        header.setType("authorization");
        LoginRequest loginEntry = new LoginRequest();

        loginRequestREST.setHeader(header);
        loginRequestREST.setData(loginEntry);

        loginResponse = new Response<LoginResponse>();
        loginResponse.setData(new LoginResponse());

        when(loginHandler.handle(loginRequestREST)).thenReturn(loginResponse);
        when(loginHandler.getName()).thenReturn("login");

        registerRequestREST = new Request<RegisterRequest>();
        ActionHeader header1 = new ActionHeader();
        header1.setCommand("register");
        header1.setType("authorization");
        RegisterRequest registerEntry = new RegisterRequest();
        registerRequestREST.setHeader(header1);
        registerRequestREST.setData(registerEntry);

        registerResponse = new Response<RegisterResponse>();
        registerResponse.setData(new RegisterResponse());

        when(registerHandler.handle(registerRequestREST)).thenReturn(registerResponse);
        when(registerHandler.getName()).thenReturn("register");

        handlers.add(loginHandler);
        handlers.add(registerHandler);

        for(AuthorizationRequestHandler h:handlers){
            handlersMap.put(h.getName(),h);
        }

    }

    @Test
    public void traceRouteToLogin(){
        Response r = router.handle(loginRequestREST);
        assertThat(r.getData(),is(instanceOf(LoginResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
        verify(loginHandler,times(1)).handle(loginRequestREST);
        verify(loginHandler,never()).handle(registerRequestREST);
    }

    @Test
    public void traceRouteToRegister(){
        Response r = router.handle(registerRequestREST);
        assertThat(r.getData(),is(instanceOf(RegisterResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
        verify(registerHandler,times(1)).handle(registerRequestREST);
        verify(registerHandler,never()).handle(loginRequestREST);
    }

}
