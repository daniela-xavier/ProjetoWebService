/*
 * AbstractControllerTest.java
 *
 * Created on 07-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * Description the class  AbstractControllerTest - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 07/02/2019
 */
public class AbstractControllerTest {

    /**
     *
     */
    @Autowired
    public WebApplicationContext wac;

    /**
     *
     */
    public MockMvc mockMvc;

}
