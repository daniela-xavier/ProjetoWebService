/*
 * DisableAction.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core.strategy.impl;

import com.proj.wsf.core.IStrategy;
import com.proj.wsf.model.DomainEntity;
import org.springframework.stereotype.Service;

/**
 * Description the class  DisableAction - Classe que implementa o método
 process do contrato com IStrategy.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */

@Service("disableAction")
public class DisableAction implements IStrategy {

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

    @Override
    public String toString() {
        return this.getClass().getSimpleName(); 
    }
    
    
}

