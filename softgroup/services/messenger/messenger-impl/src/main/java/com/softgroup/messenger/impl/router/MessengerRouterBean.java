package com.softgroup.messenger.impl.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by user on 27.02.2017.
 */

@Configuration
public class MessengerRouterBean {

    @Bean
    public MessengerRouter profileRouter(){
        return new MessengerRouter();
    }
}

