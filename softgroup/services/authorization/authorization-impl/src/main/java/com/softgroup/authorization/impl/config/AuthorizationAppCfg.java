package com.softgroup.authorization.impl.config;

import com.softgroup.authorization.impl.data.ConfirmationRegisterCache;
import com.softgroup.authorization.api.cache.ConfirmationRegisterDataCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by user on 26.02.2017.
 */
@Configuration
@ComponentScan("com.softgroup.authorization")
public class AuthorizationAppCfg {

    @Bean
    public ConfirmationRegisterDataCache makeRegisterCache() {

        return new ConfirmationRegisterCache();

    }
}
