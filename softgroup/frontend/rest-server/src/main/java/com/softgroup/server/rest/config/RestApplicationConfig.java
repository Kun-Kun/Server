package com.softgroup.server.rest.config;

import com.softgroup.authorization.impl.config.AuthorizationAppCfg;
import com.softgroup.common.cache.config.CommonCacheConfig;
import com.softgroup.common.conf.SmsServiceAppCfg;
import com.softgroup.common.config.MapstructMapperConfig;
import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.filter.config.RequestFilterAppCfg;
import com.softgroup.messenger.impl.conf.MessengerAppCfg;
import com.softgroup.multicast.notifier.config.WebSocketMulticastNotifierConfig;
import com.softgroup.profile.impl.config.ProfileAppCfg;
import com.softgroup.router.type.impl.conf.TypeRouterAppCfg;
import com.softgroup.server.socket.config.WebSocketConfig;
import com.softgroup.server.tools.service.config.ControllerToolsConfig;
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
@Import({TypeRouterAppCfg.class,
        AuthorizationAppCfg.class,
        MessengerAppCfg.class,
        ProfileAppCfg.class,
        TokenServiceAppCfg.class,
        RequestFilterAppCfg.class,
        SmsServiceAppCfg.class,
        CommonDaoAppCfg.class,
        WebSocketConfig.class,
        DataMapperAppCfg.class,
        ControllerToolsConfig.class,
        WebSocketMulticastNotifierConfig.class,
        CommonCacheConfig.class,
        MapstructMapperConfig.class
})
public class RestApplicationConfig {


}