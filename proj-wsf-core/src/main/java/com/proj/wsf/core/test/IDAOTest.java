/*
 * IDAOTest.java
 *
 * Created on 31-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.core.test;

/**
 * Description the class IDAOTest - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 31/01/2019
 */
public interface IDAOTest {

    /**
     * Teste do procedimento salvar
     */
    public void testSave();

    /**
     * Teste do procedimento alterar
     */
    public void testUpdate();

    /**
     * Teste do procedimento disabilitar
     */
    public void testDelete();

    /**
     * Teste do procedimento deletar
     */
    public void testDeleteById();

    /**
     * Teste do procedimento buscar tudo
     */
    public void testFindAll();

    /**
     * Teste do procedimento buscar um
     */
    public void testFindOne();

    /**
     * Teste do procedimento buscar por criterios
     */
    public void testFindByCriteria();

}
