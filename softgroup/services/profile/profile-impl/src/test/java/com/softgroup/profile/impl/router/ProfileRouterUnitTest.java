package com.softgroup.profile.impl.router;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.profile.api.message.ContactsSyncRequest;
import com.softgroup.profile.api.message.ContactsSyncResponse;
import com.softgroup.profile.api.message.GetContactProfilesRequest;
import com.softgroup.profile.api.message.GetContactProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.impl.handler.ContactsSyncRequestHandler;
import com.softgroup.profile.impl.handler.GetContactProfilesRequestHandler;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

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
    @Spy
    private ContactsSyncRequestHandler contactsSyncHandler;
    @Spy
    private GetContactProfilesRequestHandler getContactProfilesHandler;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<ContactsSyncRequest> contactsSyncRequestREST;
    private Request<GetContactProfilesRequest> getContactProfilesRequestREST;

    @Before
    public void createRequestResponse(){
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

        handlers.add(contactsSyncHandler);
        handlers.add(getContactProfilesHandler);

        for(ProfileRequestHandler h:handlers){
            handlersMap.put(h.getName(),h);
        }

    }

    @Test
    public void traceRouteToContactsSync(){
        Response r = router.handle(contactsSyncRequestREST);
        assertThat(r.getData(),is(instanceOf(ContactsSyncResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
        verify(contactsSyncHandler).handle(contactsSyncRequestREST);
        verify(contactsSyncHandler,never()).handle(getContactProfilesRequestREST);
    }

    @Test
    public void traceRouteToGetContactProfiles(){
        Response r = router.handle(getContactProfilesRequestREST);
        assertThat(r.getData(),is(instanceOf(GetContactProfilesResponse.class)));
        assertThat(r,is(instanceOf(Response.class)));
        verify(getContactProfilesHandler).handle(getContactProfilesRequestREST);
        verify(getContactProfilesHandler,never()).handle(contactsSyncRequestREST);
    }


}

