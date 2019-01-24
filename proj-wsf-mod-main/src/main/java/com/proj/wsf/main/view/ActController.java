/*
 * ActController.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.main.view;

import com.proj.wsf.main.model.Act;
import com.proj.wsf.view.controller.DomainEntityController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description the class  ActController - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Controller(value = "actController")
@RequestMapping("/act")
public class ActController extends DomainEntityController<Act> {

    public ActController() {
        super(Act.class);
    }
}

