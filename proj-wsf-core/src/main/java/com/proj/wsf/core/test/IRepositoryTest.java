/*
 * IRepositoryTest.java
 *
 * Created on 31-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
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

    /**
     * Teste do procedimento salvar
     */
    public void save();  

    /**
     * Teste do procedimento alterar
     */
    public void update();  

     /**
     * Teste do procedimento disabilitar
     */
    public void delete();

    /**
     * Teste do procedimento buscar por criterios
     */
    public void findByFilter();

    /**
     * Teste do procedimento buscar tudo
     */
    public void findAll();

     /**
     * Teste do procedimento buscar por id
     */
    public void findById();
}

