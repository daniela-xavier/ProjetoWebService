/*
 * SwaggerConfig.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.view.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description the class SwaggerConfig - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Bean de configuração do swagger 2.
     * @return Docket
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // .apis(RequestHandlerSelectors.basePackage("com.proj.wsf"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    /**
     * Metodo de metainfo para swagger.
     * @return ApiInfo
     */
    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Web Service Foz API REST",
                "API REST de micro servicos Foz.",
                "1.0",
                "Terms of Service",
                new Contact("Daniela Xavier Conceição", "daniela.xavier.con@outlook.com.br", "sistemas@fozadvogados.com.br"),
                "License Version 2.0",
                "XXXXXX", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
