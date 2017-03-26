package com.softgroup.server.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by user on 26.03.2017.
 */
@Configuration
@ComponentScan(basePackages = "com.softgroup",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
)
public class RestApplicationConfig {


}