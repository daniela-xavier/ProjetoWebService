/*
 * ADomainEntity.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.model.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description the class  ADomainEntity - Classe que contém a anotação para as services de entidades.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ADomainEntity {

    /**
     * Atributo de nome da entidade.
     * @return nome
     */
    String nome();
    
    /**
     * Retorna a classe da entidade.
     * @return Class<'Entity'>
     */
    Class<?> classe();
}

