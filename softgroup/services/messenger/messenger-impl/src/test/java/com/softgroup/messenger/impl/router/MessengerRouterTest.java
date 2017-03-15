package com.softgroup.messenger.impl.router;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.Handler;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
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
 * Created by user on 27.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MessengerRouterTest.LessonRouterTestCfg.class})
public class MessengerRouterTest {

    @Autowired
    MessengerRouter router;

    @Autowired
    @Qualifier("create_conversation")
    private Handler createConversation;

    @Autowired
    @Qualifier("delete_conversation")
    private Handler deleteConversation;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<CreateConversationRequest> createConversationRequestREST;
    private Request<DeleteConversationRequest> deleteConversationRequestREST;
    private Request badRequestREST;

    @Before
    public void createRequests(){
        createConversationRequestREST = new Request<CreateConversationRequest>();
        ActionHeader header = new ActionHeader();
        header.setCommand("create_conversation");
        header.setType("messenger");
        CreateConversationRequest createConversationEntry = new CreateConversationRequest();
        createConversationRequestREST.setHeader(header);
        createConversationRequestREST.setData(createConversationEntry);

        deleteConversationRequestREST = new Request<DeleteConversationRequest>();
        ActionHeader header1 = new ActionHeader();
        header1.setCommand("delete_conversation");
        header1.setType("messenger");
        DeleteConversationRequest deleteConversationEntry = new DeleteConversationRequest();
        deleteConversationRequestREST.setHeader(header1);
        deleteConversationRequestREST.setData(deleteConversationEntry);

        badRequestREST = new Request();
        ActionHeader header3 = new ActionHeader();
        header3.setCommand("sms_conform");
        header3.setType("auth");
        badRequestREST.setHeader(header3);

    }

    @Test
    public void traceRouteToCreateConversation(){
        Response r = router.handle(createConversationRequestREST);
        verify(createConversation).handle(createConversationRequestREST);
        verify(deleteConversation, never()).handle(createConversationRequestREST);
    }

    @Test
    public void traceRouteToDeleteConversation(){
        Response r = router.handle(deleteConversationRequestREST);
        verify(deleteConversation).handle(deleteConversationRequestREST);
        verify(createConversation, never()).handle(deleteConversationRequestREST);
    }

    @Test(expected = NullPointerException.class)
    public void traceRouteToErrorHandler(){
        router.handle(badRequestREST);
    }

    @Configuration
    public static class LessonRouterTestCfg {

        @Bean
        public MessengerRouter AuthorizationRouter() {
            return new MessengerRouter();
        }

        @Bean(name = "create_conversation")
        public MessengerRequestHandler handler() {
            MessengerRequestHandler handler = Mockito.mock(MessengerRequestHandler.class);
            when(handler.getName())
                    .thenReturn("create_conversation");
            return handler;
        }

        @Bean(name = "delete_conversation")
        public MessengerRequestHandler handler2() {
            MessengerRequestHandler handler = Mockito.mock(MessengerRequestHandler.class);
            when(handler.getName())
                    .thenReturn("delete_conversation");
            return handler;
        }

    }
}
