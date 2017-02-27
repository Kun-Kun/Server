package com.softgroup.messenger.impl.router;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.impl.handler.CreateConversationRequestHandler;
import com.softgroup.messenger.impl.handler.DeleteConversationRequestHandler;
import com.softgroup.messenger.impl.handler.GetConversationsByIdsRequestHandler;
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
 * Created by user on 27.02.2017.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MessengerRouterBean.class, CreateConversationRequestHandler.class,
        DeleteConversationRequestHandler.class,
        GetConversationsByIdsRequestHandler.class})
public class MessengerRouterTest {

    @Autowired
    MessengerRouter router;

    @Test
    public void isRouterExist(){
        assertThat(router, CoreMatchers.notNullValue());
    }

    private Request<CreateConversationRequest> createConversationRequestREST;
    private Request<DeleteConversationRequest> deleteConversationRequestREST;
    private Request<GetConversationsByIdsRequest> getConversationsByIdsRequestREST;
    private Request badRequestREST;

    @Before
    public void createRequests(){
        createConversationRequestREST = new Request<CreateConversationRequest>();
        ActionHeader header = new ActionHeader();
        header.setCommand("create_conversation");
        header.setType("messenger");
        header.setVersion("0");
        header.setUuid("0000");
        CreateConversationRequest createConversationEntry = new CreateConversationRequest();
        createConversationRequestREST.setHeader(header);
        createConversationRequestREST.setData(createConversationEntry);

        deleteConversationRequestREST = new Request<DeleteConversationRequest>();
        ActionHeader header1 = new ActionHeader();
        header1.setCommand("delete_conversation");
        header1.setType("messenger");
        header1.setVersion("0");
        header1.setUuid("0000");
        DeleteConversationRequest deleteConversationEntry = new DeleteConversationRequest();
        deleteConversationRequestREST.setHeader(header1);
        deleteConversationRequestREST.setData(deleteConversationEntry);

        getConversationsByIdsRequestREST = new Request<GetConversationsByIdsRequest>();
        ActionHeader header2 = new ActionHeader();
        header2.setCommand("get_conversations_by_ids");
        header2.setType("messenger");
        header2.setVersion("0");
        header2.setUuid("0000");
        GetConversationsByIdsRequest getConversationsByIdEntry = new GetConversationsByIdsRequest();
        getConversationsByIdsRequestREST.setHeader(header2);
        getConversationsByIdsRequestREST.setData(getConversationsByIdEntry);

        badRequestREST = new Request();
        ActionHeader header3 = new ActionHeader();
        header3.setCommand("sms_conform");
        header3.setType("auth");
        header3.setVersion("0");
        header3.setUuid("0000");
        badRequestREST.setHeader(header3);

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
