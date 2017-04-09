package com.softgroup.authorization.impl.router;

import com.softgroup.common.factory.AbstractHandlerFactory;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Created by user on 26.02.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorizationRouterUnitTest {

    @InjectMocks
    private AuthorizationRouter router;

    @Mock
    private AbstractHandlerFactory factory;

    @Mock
    private Handler handler;

    @Mock
    Request request;

    @Before
    public void prepareFactory(){
        when(factory.getHandler(anyObject())).thenReturn(handler);
    }

    @Test
    public void routerHandleHandler(){
        router.handle(request);
        verify(handler,times(1)).handle(request);
    }

}
