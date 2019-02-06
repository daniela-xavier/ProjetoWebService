/*
 * ShutdownController.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.view.controller;

import com.proj.wsf.view.ProjWsfViewApplication;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description the class ShutdownController - xxxxx
 *
 * @author Daniela Xavier Concei��o - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@RestController
public class ShutdownController {

    @PostMapping("/shutdownContext")
    public String shutdownContext() {
        //ProjWsfViewApplication.shutdown();
        return "Web Service sendo desligado.";
    }

}
