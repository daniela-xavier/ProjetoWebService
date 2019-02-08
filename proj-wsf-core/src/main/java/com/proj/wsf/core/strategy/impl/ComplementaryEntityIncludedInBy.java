/*
 * ComplementaryEntityIncludedInBy.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.core.strategy.impl;

import com.proj.wsf.core.IStrategy;
import com.proj.wsf.model.DomainEntity;
import java.util.Calendar;
import java.util.Date;

/**
 * Description the class ComplementaryEntityIncludedInBy - Classe que implementa
 * o método process do contrato com IStrategy.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 23/01/2019
 */
public class ComplementaryEntityIncludedInBy implements IStrategy {

    /**
     * Método que realiza o process do método strategy, Adiciona usuario
     * 'FOZWEBSERVICE' e a data atual na entity passada por parametro, atributos
     * de inclusao.
     *
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
        if (entity.getUser().isEmpty()) {
            entity.setIncludedBy("FOZWSF");
        } else {
            entity.setIncludedBy(entity.getUser());
        }
        Date data = Calendar.getInstance().getTime();
        entity.setIncludedIn(data);
        return null;
    }
}
