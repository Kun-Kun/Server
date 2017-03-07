package com.softgroup.authorization.impl.router;

import com.softgroup.authorization.api.message.*;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.Handler;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


/**
 * Created by user on 26.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AuthorizationRouterTest.LessonRouterTestCfg.class})
public class AuthorizationRouterTest {

    @Autowired
    private AuthorizationRouter router;

    @Autowired
    @Qualifier("register")
    private Handler registerHandler;

    @Autowired
    @Qualifier("login")
    private Handler loginHander;

    @Test
    public void isRouterExist() {
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<LoginRequest> loginRequestREST;
    private Request<RegisterRequest> registerRequestREST;
    private Request badRequestREST;

    @Before
    public void createRequests() {
        loginRequestREST = new Request<LoginRequest>();
        ActionHeader header = new ActionHeader();
        header.setCommand("login");
        header.setType("authorization");
        LoginRequest loginEntry = new LoginRequest();
        loginRequestREST.setHeader(header);
        loginRequestREST.setData(loginEntry);

        registerRequestREST = new Request<RegisterRequest>();
        ActionHeader header1 = new ActionHeader();
        header1.setCommand("register");
        header1.setType("authorization");
        RegisterRequest registerEntry = new RegisterRequest();
        registerRequestREST.setHeader(header1);
        registerRequestREST.setData(registerEntry);

        badRequestREST = new Request();
        ActionHeader header3 = new ActionHeader();
        header3.setCommand("bad_command");
        header3.setType("bad_type");
        badRequestREST.setHeader(header3);

    }

    @Test
    public void traceRouteToLogin() {
        Response r = router.handle(loginRequestREST);
        verify(loginHander).handle(loginRequestREST);
        verify(registerHandler, never()).handle(loginRequestREST);
    }

    @Test
    public void traceRouteToRegister() {
        Response r = router.handle(registerRequestREST);
        verify(registerHandler).handle(registerRequestREST);
        verify(loginHander, never()).handle(registerRequestREST);

    }

    @Test(expected = NullPointerException.class)
    public void traceRouteToErrorHandler() {
        Response r = router.handle(badRequestREST);
    }


    @Configuration
    public static class LessonRouterTestCfg {

        @Bean
        public AuthorizationRouter AuthorizationRouter() {
            return new AuthorizationRouter();
        }

        @Bean(name = "register")
        public AuthorizationRequestHandler handler() {
            AuthorizationRequestHandler handler = Mockito.mock(AuthorizationRequestHandler.class);
            when(handler.getName())
                    .thenReturn("register");
            return handler;
        }

        @Bean(name = "login")
        public AuthorizationRequestHandler handler2() {
            AuthorizationRequestHandler handler = Mockito.mock(AuthorizationRequestHandler.class);
            when(handler.getName())
                    .thenReturn("login");
            return handler;
        }

    }

}