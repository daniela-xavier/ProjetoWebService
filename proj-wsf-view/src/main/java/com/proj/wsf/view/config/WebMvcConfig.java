/*
 * WebMvcConfig.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.view.config;

import com.proj.wsf.view.controller.DomainEntityController;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Description the class  WebMvcConfig -  Classe de configuração para requisições
 * web em MVC.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.proj.wsf.*"}, basePackageClasses = DomainEntityController.class)
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * Método de configuração de pasta de pagina da aplicação.
     * @return InternalResourceViewResolver
     */
    /* @Bean
    public InternalResourceViewResolver resolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setViewClass(JstlView.class);
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
    }*/

    /**
     * Método de retorne mensagem da aplicação.
     * @return MessageSource
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }

    /*  @Override
   public Validator getValidator() {
   LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
   validator.setValidationMessageSource(messageSource());
   return validator;
   }*/
}
