/*
 * IStrategy.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.core;

import com.proj.wsf.model.DomainEntity;

/**
 * Description the class  IStrategy - Classe que implementa o padrão strategy.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */

public interface IStrategy {

    /**
     * Método que realiza o process do método strategy.
     * @param entidade
     * @return String
     */
    public String process(DomainEntity entidade);
}

