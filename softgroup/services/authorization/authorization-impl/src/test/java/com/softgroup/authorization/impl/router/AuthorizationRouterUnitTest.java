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
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    private LoginRequestHandler loginHandler;
    @Mock
    private RegisterRequestHandler registerHandler;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<LoginRequest> loginRequestREST;
    private Request<RegisterRequest> registerRequestREST;
    private Request<SmsConfirmRequest> smsConfirmRequestREST;
    private Response<LoginResponse> loginResponse;
    private Response<RegisterResponse> registerResponse;

    private Request badRequestREST;

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

        badRequestREST = new Request();
        ActionHeader header3 = new ActionHeader();
        header3.setCommand("sms_conform");
        header3.setType("auth");
        header3.setVersion("0");
        header3.setUuid("0000");
        badRequestREST.setHeader(header3);

    }

    @Test
    public void traceRouteToLogin(){
        Response r = router.handle(loginRequestREST);
        assertThat(r.getData(),is(instanceOf(LoginResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
        verify(loginHandler).handle(loginRequestREST);
        verify(loginHandler,never()).handle(registerRequestREST);
    }

    @Test
    public void traceRouteToRegister(){
        Response r = router.handle(registerRequestREST);
        assertThat(r.getData(),is(instanceOf(RegisterResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
        verify(registerHandler).handle(registerRequestREST);
        verify(registerHandler,never()).handle(loginRequestREST);
    }


    @Test
    public void traceRouteToErrorHandler(){
        Response r = router.handle(badRequestREST);
        assertThat(r.getStatus().getCode(),is(422));
        assertThat(r,is(instanceOf(Response.class)));
    }
}
