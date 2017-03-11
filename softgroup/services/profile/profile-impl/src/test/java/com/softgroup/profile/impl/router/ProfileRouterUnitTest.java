package com.softgroup.profile.impl.router;

import com.softgroup.common.protocol.*;
import com.softgroup.profile.api.router.ProfileRequestHandler;
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
 * Created by user on 03.03.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfileRouterUnitTest {

    @InjectMocks
    private ProfileRouter router;

    @Spy
    private ArrayList<ProfileRequestHandler> handlers;
    @Spy
    private HashMap<String,ProfileRequestHandler> handlersMap;
    @Mock
    private ProfileRequestHandler contactsSyncHandler;
    @Mock
    private ProfileRequestHandler getContactProfilesHandler;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<RequestData> contactsSyncRequestREST;
    private Request<RequestData> getContactProfilesRequestREST;
    private Response contactsSyncResponse;
    private Response getContactProfilesResponse;

    @Before
    public void createRequestResponse(){
        contactsSyncRequestREST = new Request<RequestData>();
        ActionHeader header = new ActionHeader();
        header.setCommand("contacts_sync");
        header.setType("profile");
        contactsSyncRequestREST.setHeader(header);

        contactsSyncResponse = new Response<ResponseData>();

        when(contactsSyncHandler.handle(contactsSyncRequestREST)).thenReturn(contactsSyncResponse);
        when(contactsSyncHandler.getName()).thenReturn("contacts_sync");

        getContactProfilesRequestREST = new Request<RequestData>();
        ActionHeader header1 = new ActionHeader();
        header1.setCommand("get_contact_profiles");
        header1.setType("profile");
        getContactProfilesRequestREST.setHeader(header1);

        getContactProfilesResponse = new Response<ResponseData>();

        when(getContactProfilesHandler.handle(getContactProfilesRequestREST)).thenReturn(getContactProfilesResponse);
        when(getContactProfilesHandler.getName()).thenReturn("get_contact_profiles");

        handlers.add(contactsSyncHandler);
        handlers.add(getContactProfilesHandler);

        for(ProfileRequestHandler h:handlers){
            handlersMap.put(h.getName(),h);
        }

    }

    @Test
    public void traceRouteToContactsSync(){
        Response r = router.handle(contactsSyncRequestREST);
        assertThat(r,is(instanceOf(Response.class)));
        verify(contactsSyncHandler).handle(contactsSyncRequestREST);
        verify(getContactProfilesHandler,never()).handle(contactsSyncRequestREST);
    }

    @Test
    public void traceRouteToGetContactProfiles(){
        Response r = router.handle(getContactProfilesRequestREST);
        assertThat(r,is(instanceOf(Response.class)));
        verify(getContactProfilesHandler).handle(getContactProfilesRequestREST);
        verify(contactsSyncHandler,never()).handle(getContactProfilesRequestREST);
    }


}

