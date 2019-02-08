/*
 * IServiceTest.java
 *
 * Created on 31-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core.test;

/**
 * Description the class  IServiceTest - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 31/01/2019
 */
public interface IServiceTest {
    
    /**
     * Repositorio do serviço
     */
    public void getRepository();

    /**
     * Strategys do serviços
     */
    public void getStrategys();

    /**
     * Recuperar classe da entidade por anotação
     */
    public void getClasse();

    /**
     * Recuperar nome da entidade da entidade por anotação
     */
    public void getEntidadeNome();
}
