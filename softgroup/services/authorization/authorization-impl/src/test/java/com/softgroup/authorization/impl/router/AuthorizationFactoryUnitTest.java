package com.softgroup.authorization.impl.router;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.impl.factory.AuthorizationFactory;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.Handler;
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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by user on 09.04.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorizationFactoryUnitTest {

    @InjectMocks
    private AuthorizationFactory factory;

    @Spy
    private ArrayList<AuthorizationRequestHandler> handlers;
    @Spy
    private HashMap<String,AuthorizationRequestHandler> handlersMap;
    @Mock
    private AuthorizationRequestHandler loginHandler;
    @Mock
    private AuthorizationRequestHandler registerHandler;

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
    public void isFactoryExist(){
        assertThat(factory, CoreMatchers.notNullValue());
    }

    @Test
    public void traceRouteToLogin(){
        Handler handler = factory.getHandler(loginRequestREST);
        assertThat(handler,is(loginHandler));
    }

    @Test
    public void traceRouteToRegister(){
        Handler handler = factory.getHandler(registerRequestREST);
        assertThat(handler,is(registerHandler));
    }

    @Test
    public void testBadRequest(){
        Request request = new Request<>();
        ActionHeader header = new ActionHeader();
        header.setCommand("badCommand");
        request.setHeader(header);
        Handler handler = factory.getHandler(request);
        assertNull(handler);
    }
}
