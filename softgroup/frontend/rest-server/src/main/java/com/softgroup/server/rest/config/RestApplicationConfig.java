package com.softgroup.server.rest.config;

import com.softgroup.authorization.impl.config.AuthorizationAppCfg;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.filter.config.RequestFilterAppCfg;
import com.softgroup.messenger.impl.conf.MessengerAppCfg;
import com.softgroup.profile.impl.config.ProfileAppCfg;
import com.softgroup.router.type.impl.conf.TypeRouterAppCfg;
import com.softgroup.token.config.TokenServiceAppCfg;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * Created by user on 26.03.2017.
 */
@Configuration
@ComponentScan(basePackages = "com.softgroup.server.rest",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
)
@Import({JacksonDataMapper.class,
        TypeRouterAppCfg.class,
        AuthorizationAppCfg.class,
        MessengerAppCfg.class,
        ProfileAppCfg.class,
        TokenServiceAppCfg.class,
        RequestFilterAppCfg.class})
public class RestApplicationConfig {


}