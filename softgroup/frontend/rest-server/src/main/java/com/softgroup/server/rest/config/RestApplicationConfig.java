package com.softgroup.server.rest.config;

import com.softgroup.common.datamapper.JacksonDataMapper;
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
@Import({JacksonDataMapper.class})
public class RestApplicationConfig {


}