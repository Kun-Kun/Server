package com.softgroup.authorization.impl.config;

import com.softgroup.authorization.api.cache.ConfirmationRegisterCache;
import com.softgroup.authorization.api.cache.PhoneNumberUUIDCache;
import com.softgroup.authorization.api.cache.SmsQuantityLimiterCache;
import com.softgroup.authorization.impl.data.ConfirmationRegisterCacheImpl;
import com.softgroup.authorization.impl.data.PhoneNumberUUIDCacheImpl;
import com.softgroup.authorization.impl.data.SmsQuantityLimiterCacheImpl;
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
    public ConfirmationRegisterCache makeRegisterCache() {
        return new ConfirmationRegisterCacheImpl();
    }

    @Bean
    public SmsQuantityLimiterCache makeSmsQuantityCache() {
        return new SmsQuantityLimiterCacheImpl();
    }

    @Bean
    public PhoneNumberUUIDCache makeReverseRegisterCache() {
        return new PhoneNumberUUIDCacheImpl();
    }
}
