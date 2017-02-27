package com.softgroup.common.impl.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by user on 27.02.2017.
 */

@Configuration
public class CommonTypeRouterBean {

    @Bean
    public CommonTypeRouter authorizationRouter(){
        return new CommonTypeRouter();
    }
}

