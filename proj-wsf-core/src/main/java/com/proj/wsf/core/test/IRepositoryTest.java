/*
 * IRepositoryTest.java
 *
 * Created on 31-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.core.test;

/**
 * Description the class  IRepositoryTest - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 31/01/2019
 */

public interface IRepositoryTest {
    public void save();  
    public void update();  
    public void delete();
    public void findByFilter();
    public void findAll();
    public void findById();
}

