/*
 * MainConfigurationController.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.main.view;

import com.proj.wsf.core.IServico;
import com.proj.wsf.core.application.Result;
import com.proj.wsf.main.model.MainConfiguration;
import com.proj.wsf.model.DomainEntity;
import com.proj.wsf.view.controller.DomainEntityController;
import com.proj.wsf.view.response.ExceptionResponse;
import com.proj.wsf.view.response.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description the class  MainConfigurationController - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Controller(value = "mainConfigurationController")
@RequestMapping("/mainConfiguration")
@CrossOrigin(origins = "*")
@Api(value="MAIN CONFIG API REST FOZ")
public class MainConfigurationController extends DomainEntityController<MainConfiguration> {

    public MainConfigurationController() {
        super(MainConfiguration.class);
    }
    
}

