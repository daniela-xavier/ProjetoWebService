/*
 * IControllerTest.java
 *
 * Created on 31-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
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

    /**
     *
     * @throws Exception
     */
    public void testGetIdSucess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testGetIdInsuccess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testGetFilterSucess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testGetFilterInsuccess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testPostSucess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testPostInsuccess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testPutSucess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testPutInsuccess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testDeleteIdSucess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testDeleteIdInsuccess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testDisableSucess() throws Exception;

    /**
     *
     * @throws Exception
     */
    public void testDisableInsuccess() throws Exception;
    

}

