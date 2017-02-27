package com.softgroup.profile.impl.router;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.profile.api.message.*;
import com.softgroup.profile.impl.handler.ContactsSyncRequestHandler;
import com.softgroup.profile.impl.handler.GetContactProfilesRequestHandler;
import com.softgroup.profile.impl.handler.GetLastTimeOnlineRequestHandler;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by maxim on 27.02.17.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileRouterBean.class, ContactsSyncRequestHandler.class,
        GetContactProfilesRequestHandler.class,
        GetLastTimeOnlineRequestHandler.class})

public class ProfileRouterTest {

    @Autowired
    ProfileRouter router;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<ContactsSyncRequest> contactsSyncRequestREST;
    private Request<GetContactProfilesRequest> getContactProfilesRequestREST;
    private Request<GetLastTimeOnlineRequest> getLastTimeOnlineRequestREST;
    private Request badRequestREST;

    @Before
    public void createRequests(){
        contactsSyncRequestREST = new Request<ContactsSyncRequest>();
        ActionHeader header = new ActionHeader();
        header.setCommand("contacts_sync");
        header.setType("profile");
        header.setVersion("0");
        header.setUuid("0000");
        ContactsSyncRequest contactsSyncEntry = new ContactsSyncRequest();
        contactsSyncRequestREST.setHeader(header);
        contactsSyncRequestREST.setData(contactsSyncEntry);

        getContactProfilesRequestREST = new Request<GetContactProfilesRequest>();
        ActionHeader header1 = new ActionHeader();
        header1.setCommand("get_contact_profiles");
        header1.setType("profile");
        header1.setVersion("0");
        header1.setUuid("0000");
        GetContactProfilesRequest getContactProfilesEntry = new GetContactProfilesRequest();
        getContactProfilesRequestREST.setHeader(header1);
        getContactProfilesRequestREST.setData(getContactProfilesEntry);

        getLastTimeOnlineRequestREST = new Request<GetLastTimeOnlineRequest>();
        ActionHeader header2 = new ActionHeader();
        header2.setCommand("get_last_time_online");
        header2.setType("profile");
        header2.setVersion("0");
        header2.setUuid("0000");
        GetLastTimeOnlineRequest lastTimeoOnLineEntry = new GetLastTimeOnlineRequest();
        getLastTimeOnlineRequestREST.setHeader(header2);
        getLastTimeOnlineRequestREST.setData(lastTimeoOnLineEntry);

        badRequestREST = new Request();
        ActionHeader header3 = new ActionHeader();
        header3.setCommand("sms_conform");
        header3.setType("auth");
        header3.setVersion("0");
        header3.setUuid("0000");
        badRequestREST.setHeader(header3);

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
    public void traceRouteToErrorHandler(){
        Response r = router.handle(badRequestREST);
        assertThat(r.getStatus().getCode(),is(422));
        assertThat(r,is(instanceOf(Response.class)));
    }
}
