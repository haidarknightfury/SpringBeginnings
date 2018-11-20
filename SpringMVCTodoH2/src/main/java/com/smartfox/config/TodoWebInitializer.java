package com.smartfox.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Single Dispatcher servlet - All in root config class
 * More than one dispatcher servlet - Root config : Data config + Security Config (Shared config)
 * - Servlet config : Specific webconfig with component scans
 *
 * @author hdargaye
 *
 */
public class TodoWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { DataConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { TodoServletConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
