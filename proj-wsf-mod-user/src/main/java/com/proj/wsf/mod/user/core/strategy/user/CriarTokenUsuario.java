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
import com.proj.wsf.core.util.JWTUtilToken;
import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.model.DomainEntity;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Description the class CadastroUnicoDeUsuario - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 08/02/2019
 */
@Service("criarTokenUsuario")
public class CriarTokenUsuario implements IStrategy {

    /**
     * Método que realiza o processamento desta classe.
     *
     * @param entity
     * @return String
     */
    @Override
    @Transactional
    public String process(DomainEntity entity) {

        if (entity instanceof User) {

            try {
                User user = (User) entity;              
                
                String token = JWTUtilToken.criarToken(entity.getUser());
                user.setToken(token);
            } catch (Exception e) {
                return "<> Não foi possível criar o token para o usuário.";
            }

            return null;
        }

        return "Entidade inválida. Não é possível executar esta ação.";
    }

}
