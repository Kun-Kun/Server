package com.softgroup.authorization.impl.router;

import com.softgroup.authorithation.impl.handler.LoginRequestHandler;
import com.softgroup.authorithation.impl.handler.RegisterRequestHandler;
import com.softgroup.authorithation.impl.handler.SmsConfirmRequestHandler;
import com.softgroup.authorithation.impl.router.AuthorizationRouter;
import com.softgroup.authorithation.impl.router.AuthorizationRouterBean;
import com.softgroup.authorization.api.message.*;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.assertThat;
/**
 * Created by user on 26.02.2017.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AuthorizationRouterBean.class, LoginRequestHandler.class, RegisterRequestHandler.class, SmsConfirmRequestHandler.class})
public class AuthorizationRouterTest {

    @Autowired
    AuthorizationRouter router;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<LoginRequest> loginRequestREST;
    private Request<RegisterRequest> registerRequestREST;
    private Request<SmsConfirmRequest> smsConfirmRequestREST;
    private Request badRequestREST;

    @Before
    public void createRequests(){
        loginRequestREST = new Request<LoginRequest>();
        ActionHeader header = new ActionHeader();
        header.setCommand("login");
        header.setType("authorization");
        header.setVersion("0");
        header.setUuid("0000");
        LoginRequest loginEntry = new LoginRequest();
        loginEntry.setDeviceToken("de:ee:ad:be:ee:ef");
        loginRequestREST.setHeader(header);
        loginRequestREST.setData(loginEntry);

        registerRequestREST = new Request<RegisterRequest>();
        ActionHeader header1 = new ActionHeader();
        header1.setCommand("register");
        header1.setType("authorization");
        header1.setVersion("0");
        header1.setUuid("0000");
        RegisterRequest registerEntry = new RegisterRequest();
        registerRequestREST.setHeader(header1);
        registerRequestREST.setData(registerEntry);

        smsConfirmRequestREST = new Request<SmsConfirmRequest>();
        ActionHeader header2 = new ActionHeader();
        header2.setCommand("sms_confirm");
        header2.setType("authorization");
        header2.setVersion("0");
        header2.setUuid("0000");
        SmsConfirmRequest smsConfirmEntry = new SmsConfirmRequest();
        smsConfirmRequestREST.setHeader(header2);
        smsConfirmRequestREST.setData(smsConfirmEntry);

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
    }

    @Test
    public void traceRouteToRegister(){
        Response r = router.handle(registerRequestREST);
        assertThat(r.getData(),is(instanceOf(RegisterResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
    }

    @Test
    public void traceRouteToSmsConfirm(){
        Response r = router.handle(smsConfirmRequestREST);
        assertThat(r.getData(),is(instanceOf(SmsConfirmResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
    }

    @Test
    public void traceRouteToErrorHandler(){
        Response r = router.handle(badRequestREST);
        assertThat(r.getStatus().getCode(),is(422));
        assertThat(r,is(instanceOf(Response.class)));
    }
}
