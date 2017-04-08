package com.softgroup.server.rest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RestApplicationConfig.class};
    }

    @Override
    public Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebApplicationConfig.class};
    }

}
