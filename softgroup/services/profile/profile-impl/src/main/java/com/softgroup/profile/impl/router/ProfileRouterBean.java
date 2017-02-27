package com.softgroup.profile.impl.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by maxim on 27.02.17.
 */
@Configuration
public class ProfileRouterBean {

    @Bean
    public ProfileRouter profileRouter(){
        return new ProfileRouter();
    }
}
