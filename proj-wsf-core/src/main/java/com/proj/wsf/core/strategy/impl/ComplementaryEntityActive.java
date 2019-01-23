/*
 * ComplementaryEntityActive.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.core.strategy.impl;

import com.proj.wsf.core.IStrategy;
import com.proj.wsf.model.DomainEntity;

/**
 * Description the class  ComplementaryEntityActive - Classe que implementa o método
 process do contrato com IStrategy.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public class ComplementaryEntityActive implements IStrategy {

    /**
     * Método que realiza o process do método strategy,
 Adiciona ativo na entidade passada por parametro.
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
        entity.setActive("S");
        return null;
    }

}


