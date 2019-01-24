/*
 * AppContainerCustomizer.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.view.config;

import org.springframework.context.annotation.Profile;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

/**
 * Description the class AppContainerCustomizer - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
public class AppContainerCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    int port = 1221;
    String path = "/WebServiceFoz";
   
    @Profile("dev")
    @Override
    public void customize(ConfigurableServletWebServerFactory server) {
        server.setContextPath(path + "Dev");
        server.setPort(port);
    }

    /* @Profile("hml")
    @Override
    public void customize(ConfigurableServletWebServerFactory server) {
    server.setContextPath(path + "Hml");
    server.setPort(port);
    }
    
    @Profile("prd")
    @Override
    public void customize(ConfigurableServletWebServerFactory server) {
    server.setContextPath(path + "Prd");
    server.setPort(port);
    }*/

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }

}
