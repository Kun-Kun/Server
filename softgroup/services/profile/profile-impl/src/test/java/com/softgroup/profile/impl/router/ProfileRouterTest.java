package com.softgroup.profile.impl.router;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.Handler;
import com.softgroup.profile.api.message.*;
import com.softgroup.profile.api.router.ProfileRequestHandler;
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
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by maxim on 27.02.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileRouterTest.LessonRouterTestCfg.class})

public class ProfileRouterTest {

    @Autowired
    ProfileRouter router;

    @Autowired
    @Qualifier("contactsSync")
    private Handler contactsSyncHandler;

    @Autowired
    @Qualifier("getContactProfiles")
    private Handler getContactProfilesHandler;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<ContactsSyncRequest> contactsSyncRequestREST;
    private Request<GetContactProfilesRequest> getContactProfilesRequestREST;
    private Request badRequestREST;

    @Before
    public void createRequests(){
        contactsSyncRequestREST = new Request<ContactsSyncRequest>();
        ActionHeader header = new ActionHeader();
        header.setCommand("contacts_sync");
        header.setType("profile");
        ContactsSyncRequest contactsSyncEntry = new ContactsSyncRequest();
        contactsSyncRequestREST.setHeader(header);
        contactsSyncRequestREST.setData(contactsSyncEntry);

        getContactProfilesRequestREST = new Request<GetContactProfilesRequest>();
        ActionHeader header1 = new ActionHeader();
        header1.setCommand("get_contact_profiles");
        header1.setType("profile");
        GetContactProfilesRequest getContactProfilesEntry = new GetContactProfilesRequest();
        getContactProfilesRequestREST.setHeader(header1);
        getContactProfilesRequestREST.setData(getContactProfilesEntry);


        badRequestREST = new Request();
        ActionHeader header3 = new ActionHeader();
        header3.setCommand("sms_conform");
        header3.setType("auth");
        badRequestREST.setHeader(header3);

    }

    @Test
    public void traceRouteToContactsSync(){
        Response r = router.handle(contactsSyncRequestREST);
        verify(contactsSyncHandler).handle(contactsSyncRequestREST);
        verify(getContactProfilesHandler, never()).handle(contactsSyncRequestREST);
    }

    @Test
    public void traceRouteToContactProfiles(){
        Response r = router.handle(getContactProfilesRequestREST);
        verify(getContactProfilesHandler).handle(getContactProfilesRequestREST);
        verify(contactsSyncHandler, never()).handle(getContactProfilesRequestREST);
    }


    @Test(expected = NullPointerException.class)
    public void traceRouteToErrorHandler(){
        router.handle(badRequestREST);
    }

    @Configuration
    public static class LessonRouterTestCfg {

        @Bean
        public ProfileRouter AuthorizationRouter() {
            return new ProfileRouter();
        }

        @Bean(name = "contactsSync")
        public ProfileRequestHandler handler() {
            ProfileRequestHandler handler = Mockito.mock(ProfileRequestHandler.class);
            when(handler.getName())
                    .thenReturn("contacts_sync");
            return handler;
        }

        @Bean(name = "getContactProfiles")
        public ProfileRequestHandler handler2() {
            ProfileRequestHandler handler = Mockito.mock(ProfileRequestHandler.class);
            when(handler.getName())
                    .thenReturn("get_contact_profiles");
            return handler;
        }

    }
}
