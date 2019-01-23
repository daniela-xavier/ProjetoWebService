/*
 * AppInitializer.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.view.config;

import com.proj.wsf.core.config.JPAConfiguration;
import com.proj.wsf.view.authenticate.AuthenticFilter;
import javax.servlet.Filter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Description the class  AppInitializer - Classe de inicialização da aplicação.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public class AppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Método de instancia as configurações de persistencia.
     *
     * @return Class
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{JPAConfiguration.class};
    }

    /**
     * Método de instancia as configurações da web com MVC.
     *
     * @return Class
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    /**
     * Método de instancia as de mapeamento da servlet.
     *
     * @return String[]
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * Método de instancia os filtros da aplicação.
     *
     * @return Filter[]
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new AuthenticFilter()};
    }

    /**
     * Método de instancia o perfil da aplicação.
     *
     * @return WebApplicationContext
     */ 
    @Override
    protected WebApplicationContext createRootApplicationContext() {

        WebApplicationContext context
                = (WebApplicationContext) super.createRootApplicationContext();
        ((ConfigurableEnvironment) context.getEnvironment()).setActiveProfiles("dev");

        return context;

    }
}
