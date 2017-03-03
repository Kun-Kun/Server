package com.softgroup.common.impl.router;

import com.softgroup.authorization.impl.router.AuthorizationRouterAppCfg;
import com.softgroup.messenger.impl.router.MessengerRouterAppCfg;
import com.softgroup.profile.impl.router.ProfileRouterAppCfg;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by user on 27.02.2017.
 */

@Configuration
@ComponentScan(value = "com.softgroup.common")
@Import({ProfileRouterAppCfg.class, MessengerRouterAppCfg.class, AuthorizationRouterAppCfg.class})
public class CommonTypeRouterAppCfg {

/*
    @Bean
    public CommonTypeRouter authorizationRouter(){
        return new CommonTypeRouter();
    }
*/
}

