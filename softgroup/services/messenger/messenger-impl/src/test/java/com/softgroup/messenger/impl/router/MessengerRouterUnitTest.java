package com.softgroup.messenger.impl.router;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
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
    public class MessengerRouterUnitTest {

        @InjectMocks
        private MessengerRouter router;

        @Spy
        private ArrayList<MessengerRequestHandler> handlers;
        @Spy
        private HashMap<String,MessengerRequestHandler> handlersMap;
        @Mock
        private MessengerRequestHandler createConversationHandler;
        @Mock
        private MessengerRequestHandler deleteConversationHandler;

        @Test
        public void isRouterExist(){
            assertThat(router, CoreMatchers.notNullValue());
        }

        private Request<CreateConversationRequest> createConversationRequestREST;
        private Request<DeleteConversationRequest> deleteConversationRequestREST;
        private Response createConversationResponseREST;
        private Response deleteConversationResponseREST;
        @Before
        public void createRequestResponse(){
            createConversationRequestREST = new Request<CreateConversationRequest>();
            ActionHeader header = new ActionHeader();
            header.setCommand("create_conversation");
            header.setType("messenger");
            CreateConversationRequest createConversationEntry = new CreateConversationRequest();
            createConversationRequestREST.setHeader(header);
            createConversationRequestREST.setData(createConversationEntry);

            createConversationResponseREST = new Response<CreateConversationResponse>();
            createConversationResponseREST.setData(new CreateConversationResponse());

            when(createConversationHandler.handle(createConversationRequestREST)).thenReturn(createConversationResponseREST);
            when(createConversationHandler.getName()).thenReturn("create_conversation");

            deleteConversationRequestREST = new Request<DeleteConversationRequest>();
            ActionHeader header1 = new ActionHeader();
            header1.setCommand("delete_conversation");
            header1.setType("messenger");
            DeleteConversationRequest deleteConversationEntry = new DeleteConversationRequest();
            deleteConversationRequestREST.setHeader(header1);
            deleteConversationRequestREST.setData(deleteConversationEntry);

            deleteConversationResponseREST = new Response<DeleteConversationResponse>();
            deleteConversationResponseREST.setData(new DeleteConversationResponse());

            when(deleteConversationHandler.handle(deleteConversationRequestREST)).thenReturn(deleteConversationResponseREST);
            when(deleteConversationHandler.getName()).thenReturn("delete_conversation");

            handlers.add(createConversationHandler);
            handlers.add(deleteConversationHandler);

            for(MessengerRequestHandler h:handlers){
                handlersMap.put(h.getName(),h);
            }

        }

        @Test
        public void traceRouteToCreateConversation(){
            Response r = router.handle(createConversationRequestREST);
            assertThat(r.getData(),is(instanceOf(CreateConversationResponse.class)));
            assertThat(r,is(instanceOf(Response.class)));
            verify(createConversationHandler).handle(createConversationRequestREST);
            verify(deleteConversationHandler,never()).handle(createConversationRequestREST);
        }

        @Test
        public void traceRouteToDeleteConversation(){
            Response r = router.handle(deleteConversationRequestREST);
            assertThat(r.getData(),is(instanceOf(DeleteConversationResponse.class)));
            assertThat(r,is(instanceOf(Response.class)));
            verify(deleteConversationHandler).handle(deleteConversationRequestREST);
            verify(createConversationHandler,never()).handle(deleteConversationRequestREST);
        }


    }

