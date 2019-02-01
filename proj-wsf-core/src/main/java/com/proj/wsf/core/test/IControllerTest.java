/*
 * IControllerTest.java
 *
 * Created on 31-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.core.test;

/**
 * Description the class  IControllerTest - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 31/01/2019
 */
public interface IControllerTest {

    public void testGetIdSucess() throws Exception;
    public void testGetIdInsuccess() throws Exception;
    public void testGetFilterSucess() throws Exception;
    public void testGetFilterInsuccess() throws Exception;
    public void testPostSucess() throws Exception;
    public void testPostInsuccess() throws Exception;
    public void testPutSucess() throws Exception;
    public void testPutInsuccess() throws Exception;
    public void testDeleteIdSucess() throws Exception;
    public void testDeleteIdInsuccess() throws Exception;
    

}

