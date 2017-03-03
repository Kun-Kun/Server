package com.softgroup.common.impl.router;

import com.softgroup.authorization.api.message.*;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.messenger.api.message.*;
import com.softgroup.profile.api.message.*;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 27.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonTypeRouterAppCfg.class})

public class CommonTypeRouterTest {

    @Autowired
    CommonTypeRouter router;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<LoginRequest> loginRequestREST;
    private Request<RegisterRequest> registerRequestREST;
    private Request<SmsConfirmRequest> smsConfirmRequestREST;

    private Request<ContactsSyncRequest> contactsSyncRequestREST;
    private Request<GetContactProfilesRequest> getContactProfilesRequestREST;
    private Request<GetLastTimeOnlineRequest> getLastTimeOnlineRequestREST;

    private Request<CreateConversationRequest> createConversationRequestREST;
    private Request<DeleteConversationRequest> deleteConversationRequestREST;
    private Request<GetConversationsByIdsRequest> getConversationsByIdsRequestREST;

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
        header3.setType("profile");
        header3.setVersion("0");
        header3.setUuid("0000");
        badRequestREST.setHeader(header3);

        contactsSyncRequestREST = new Request<ContactsSyncRequest>();
        ActionHeader header4 = new ActionHeader();
        header4.setCommand("contacts_sync");
        header4.setType("profile");
        header4.setVersion("0");
        header4.setUuid("0000");
        ContactsSyncRequest contactsSyncEntry = new ContactsSyncRequest();
        contactsSyncRequestREST.setHeader(header4);
        contactsSyncRequestREST.setData(contactsSyncEntry);

        getContactProfilesRequestREST = new Request<GetContactProfilesRequest>();
        ActionHeader header5 = new ActionHeader();
        header5.setCommand("get_contact_profiles");
        header5.setType("profile");
        header5.setVersion("0");
        header5.setUuid("0000");
        GetContactProfilesRequest getContactProfilesEntry = new GetContactProfilesRequest();
        getContactProfilesRequestREST.setHeader(header5);
        getContactProfilesRequestREST.setData(getContactProfilesEntry);

        getLastTimeOnlineRequestREST = new Request<GetLastTimeOnlineRequest>();
        ActionHeader header6 = new ActionHeader();
        header6.setCommand("get_last_time_online");
        header6.setType("profile");
        header6.setVersion("0");
        header6.setUuid("0000");
        GetLastTimeOnlineRequest lastTimeoOnLineEntry = new GetLastTimeOnlineRequest();
        getLastTimeOnlineRequestREST.setHeader(header6);
        getLastTimeOnlineRequestREST.setData(lastTimeoOnLineEntry);

        createConversationRequestREST = new Request<CreateConversationRequest>();
        ActionHeader header7 = new ActionHeader();
        header7.setCommand("create_conversation");
        header7.setType("messenger");
        header7.setVersion("0");
        header7.setUuid("0000");
        CreateConversationRequest createConversationEntry = new CreateConversationRequest();
        createConversationRequestREST.setHeader(header7);
        createConversationRequestREST.setData(createConversationEntry);

        deleteConversationRequestREST = new Request<DeleteConversationRequest>();
        ActionHeader header8 = new ActionHeader();
        header8.setCommand("delete_conversation");
        header8.setType("messenger");
        header8.setVersion("0");
        header8.setUuid("0000");
        DeleteConversationRequest deleteConversationEntry = new DeleteConversationRequest();
        deleteConversationRequestREST.setHeader(header8);
        deleteConversationRequestREST.setData(deleteConversationEntry);

        getConversationsByIdsRequestREST = new Request<GetConversationsByIdsRequest>();
        ActionHeader header9 = new ActionHeader();
        header9.setCommand("get_conversations_by_ids");
        header9.setType("messenger");
        header9.setVersion("0");
        header9.setUuid("0000");
        GetConversationsByIdsRequest getConversationsByIdEntry = new GetConversationsByIdsRequest();
        getConversationsByIdsRequestREST.setHeader(header9);
        getConversationsByIdsRequestREST.setData(getConversationsByIdEntry);

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
    public void traceRouteToContactsSync(){
        Response r = router.handle(contactsSyncRequestREST);
        assertThat(r.getData(),is(instanceOf(ContactsSyncResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
    }

    @Test
    public void traceRouteToContactProfiles(){
        Response r = router.handle(getContactProfilesRequestREST);
        assertThat(r.getData(),is(instanceOf(GetContactProfilesResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
    }

    @Test
    public void traceRouteLastTimeOnline(){
        Response r = router.handle(getLastTimeOnlineRequestREST);
        assertThat(r.getData(),is(instanceOf(GetLastTimeOnlineResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
    }

    @Test
    public void traceRouteToCreateConversation(){
        Response r = router.handle(createConversationRequestREST);
        assertThat(r.getData(),is(instanceOf(CreateConversationResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
    }

    @Test
    public void traceRouteToDeleteConversation(){
        Response r = router.handle(deleteConversationRequestREST);
        assertThat(r.getData(),is(instanceOf(DeleteConversationResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
    }

    @Test
    public void traceRouteGetConversationsByIds(){
        Response r = router.handle(getConversationsByIdsRequestREST);
        assertThat(r.getData(),is(instanceOf(GetConversationsByIdsResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
    }
    @Test
    public void traceRouteToErrorHandler(){
        Response r = router.handle(badRequestREST);
        assertThat(r.getStatus().getCode(),is(422));
        assertThat(r,is(instanceOf(Response.class)));
    }

}
