package com.softgroup.filter.impl;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;
import com.softgroup.filter.config.RequestFilterAppCfg;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by user on 10.04.2017.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {RequestFilterAppCfg.class})
public class RequestFilterTest {

    @InjectMocks
    private AllowRequestBorderFilter allowRequestBorderFilter;

    @InjectMocks
    private DenyRequestBorderFilter denyRequestBorderFilter;

    @Mock
    private Handler handler;

    private Request loginRequestREST;
    private Request createConversationRequestREST;
    @Before
    public void prepare(){
        loginRequestREST = new Request<>();
        ActionHeader header = new ActionHeader();
        header.setCommand("login");
        header.setType("authorization");
        loginRequestREST.setHeader(header);

        createConversationRequestREST = new Request();
        ActionHeader header1 = new ActionHeader();
        header1.setCommand("create_conversation");
        header1.setType("messenger");
        createConversationRequestREST.setHeader(header1);

    }

    @Test
    public void testAllowBorderFilter(){
        allowRequestBorderFilter.handle(loginRequestREST);
        allowRequestBorderFilter.handle(createConversationRequestREST);
        verify(handler).handle(loginRequestREST);
        verify(handler,never()).handle(createConversationRequestREST);
    }

    @Test
    public void testDenyBorderFilter(){
        denyRequestBorderFilter.handle(loginRequestREST);
        denyRequestBorderFilter.handle(createConversationRequestREST);
        verify(handler,never()).handle(loginRequestREST);
        verify(handler).handle(createConversationRequestREST);
    }
}
