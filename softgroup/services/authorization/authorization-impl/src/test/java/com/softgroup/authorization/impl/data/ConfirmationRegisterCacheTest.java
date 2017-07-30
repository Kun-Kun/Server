package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.ConfirmationRegisterDataCache;
import com.softgroup.authorization.impl.config.AuthorizationAppCfg;
import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by user on 13.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AuthorizationAppCfg.class, DataMapperAppCfg.class})
public class ConfirmationRegisterCacheTest {

    @Autowired
    private ConfirmationRegisterDataCache cache1;

    @Autowired
    private ConfirmationRegisterDataCache cache2;
    @Test
    public void checkCacheServiceSingleton() throws Exception {
        assertNotNull(cache1);
        assertEquals(cache1,cache2);
    }

}