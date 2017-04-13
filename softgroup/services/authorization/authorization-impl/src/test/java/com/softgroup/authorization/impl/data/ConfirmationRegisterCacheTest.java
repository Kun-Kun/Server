package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.ConfirmationRegisterData;
import com.softgroup.authorization.api.cache.ConfirmationRegisterDataCache;
import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.impl.config.AuthorizationAppCfg;
import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by user on 13.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AuthorizationAppCfg.class, DataMapperAppCfg.class})
public class ConfirmationRegisterCacheTest {

    @Autowired
    private ConfirmationRegisterDataCache cache;

    @Test
    public void makeRegisterCache() throws Exception {

        for (int i = 0; i < 700; i++) {
            ConfirmationRegisterData data = new ConfirmationRegisterData(new RegisterRequest());
            cache.put(data.getRegistrationRequestUUID(),data);
            Thread.sleep(1000);
            System.out.println(cache.size());
        }

    }

}