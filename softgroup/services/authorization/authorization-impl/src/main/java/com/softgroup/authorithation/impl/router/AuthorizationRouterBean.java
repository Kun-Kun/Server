package com.softgroup.authorithation.impl.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by user on 26.02.2017.
 */
@Configuration
public class AuthorizationRouterBean {

    @Bean
    public AuthorizationRouter authorizationRouter(){
        return new AuthorizationRouter();
    }
}
