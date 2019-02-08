/*
 * CadastroUnicoDeUsuario.java
 *
 * Created on 08-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.mod.user.core.strategy.user;

import com.proj.wsf.core.IStrategy;
import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.model.DomainEntity;

/**
 * Description the class CadastroUnicoDeUsuario - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 08/02/2019
 */
public class CadastroUnicoDeUsuario implements IStrategy {

    /**
     * Método que realiza o processamento desta classe.
     *
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
        
        if (entity instanceof User) {
            User user = (User) entity;
            
            return null;
        }

        return "Entidade inválida. Não é possível executar esta ação.";
    }
}
