package com.softgroup.server.rest.config;

import com.softgroup.server.rest.security.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RestApplicationConfig.class, WebSecurityConfig.class};
    }

    @Override
    public Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebApplicationConfig.class};
    }

}
