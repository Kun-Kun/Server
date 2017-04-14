package com.softgroup.common.conf;

import com.softgroup.common.sms.AndroidSmsGatewayApp;
import com.softgroup.common.sms.SmsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by user on 14.04.2017.
 */
@Configuration
public class SmsServiceAppCfg {

    @Bean
    public SmsService setupSms(){
        return new AndroidSmsGatewayApp();
    }
}
