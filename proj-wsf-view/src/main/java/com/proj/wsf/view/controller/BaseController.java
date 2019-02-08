/*
 * BaseController.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.view.controller;

import com.proj.wsf.core.application.EntityApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description the class  BaseController - Classe base para as requisiçães do
 * WebService.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class BaseController extends EntityApplication {
}
