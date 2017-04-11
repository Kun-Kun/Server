package com.softgroup.profile.impl.router;

import com.softgroup.common.factory.AbstractHandlerFactory;
import com.softgroup.common.protocol.*;
import com.softgroup.common.router.api.Handler;
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
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

/**
 * Created by user on 03.03.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfileRouterUnitTest {

    @InjectMocks
    private ProfileRouter router;

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

