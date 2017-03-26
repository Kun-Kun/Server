package com.softgroup.server.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.softgroup.server"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
)
public class WebApplicationConfig extends WebMvcConfigurerAdapter {


}
