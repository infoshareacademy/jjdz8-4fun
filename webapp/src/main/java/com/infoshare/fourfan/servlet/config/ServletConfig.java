package com.infoshare.fourfan.servlet.config;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletConfig implements ServletContextListener {

    @Inject
    protected WebInfPathResolver webInfPathResolver;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        webInfPathResolver.setWebInfPath(servletContextEvent.getServletContext().getRealPath("/WEB-INF"));
    }
}
