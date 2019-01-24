/*
 * MicroServiceController.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.main.view;

import com.proj.wsf.main.model.MicroService;
import com.proj.wsf.view.controller.DomainEntityController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description the class  MicroServiceController - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Controller(value = "microServiceController")
@RequestMapping("/microService")
public class MicroServiceController extends DomainEntityController<MicroService> {

    public MicroServiceController() {
        super(MicroService.class);
    }
}
