package com.softgroup.messenger.impl.router;

import com.softgroup.common.protocol.*;
import com.softgroup.common.router.api.Handler;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.factory.MessengerFactory;
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
import static org.mockito.Mockito.when;

/**
 * Created by user on 09.04.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class MessengerFactoryUnitTest {

    @InjectMocks
    private MessengerFactory factory;

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
        assertThat(factory, CoreMatchers.notNullValue());
    }

    private Request<RequestData> createConversationRequestREST;
    private Request<RequestData> deleteConversationRequestREST;
    private Response createConversationResponseREST;
    private Response deleteConversationResponseREST;
    @Before
    public void createRequestResponse(){
        createConversationRequestREST = new Request<RequestData>();
        ActionHeader header = new ActionHeader();
        header.setCommand("create_conversation");
        header.setType("messenger");
        createConversationRequestREST.setHeader(header);


        createConversationResponseREST = new Response<ResponseData>();

        when(createConversationHandler.handle(createConversationRequestREST)).thenReturn(createConversationResponseREST);
        when(createConversationHandler.getName()).thenReturn("create_conversation");

        deleteConversationRequestREST = new Request<RequestData>();
        ActionHeader header1 = new ActionHeader();
        header1.setCommand("delete_conversation");
        header1.setType("messenger");
        deleteConversationRequestREST.setHeader(header1);

        deleteConversationResponseREST = new Response<ResponseData>();

        when(deleteConversationHandler.handle(deleteConversationRequestREST)).thenReturn(deleteConversationResponseREST);
        when(deleteConversationHandler.getName()).thenReturn("delete_conversation");

        handlers.add(createConversationHandler);
        handlers.add(deleteConversationHandler);

        for(MessengerRequestHandler h:handlers){
            handlersMap.put(h.getName(),h);
        }

    }


    @Test
    public void isFactoryExist(){
        assertThat(factory, CoreMatchers.notNullValue());
    }

    @Test
    public void traceRouteToCreateConversation(){
        Handler handler = factory.getHandler(createConversationRequestREST);
        assertThat(handler,is(createConversationHandler));
    }

    @Test
    public void traceRouteToDeleteConversation(){
        Handler handler = factory.getHandler(deleteConversationRequestREST);
        assertThat(handler,is(deleteConversationHandler));
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
