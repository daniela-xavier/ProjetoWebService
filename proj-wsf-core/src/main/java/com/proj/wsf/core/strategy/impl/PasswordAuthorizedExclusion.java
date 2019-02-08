/*
 * PasswordAuthorizedExclusion.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core.strategy.impl;

import com.proj.wsf.core.IStrategy;
import com.proj.wsf.model.DomainEntity;

/**
 * Description the class  PasswordAuthorizedExclusion - Classe que implementa o método
 process do contrato com IStrategy.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public class PasswordAuthorizedExclusion implements IStrategy {

    /**
     * Método que não permite a execução desta ação.
     *
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
        return "Processos inválido. Não é possível executar esta ação.";
    }
}

