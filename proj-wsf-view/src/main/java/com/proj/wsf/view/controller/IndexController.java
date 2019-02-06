/*
 * RestartController.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.view.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description the class RestartController - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@RestController
public class IndexController {

    /**
    * MÃ©todo para requisiÃ§Ã£es GET na raiz do projeto.
    *
    * @return String
    */
    @GetMapping("/foz")
    @ApiOperation(value="Index da aplicação")
    public String index() {
        return "Bem vindo(a) ao WebServiceFoz"
                + "\t Documentação do projeto: " + "http://localhost:1221/WebServiceFozDev/swagger-ui.html";
    }


}
