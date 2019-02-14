/*
 * ComplementaryEntityActive.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core.strategy.impl;

import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.util.JWTUtilToken;
import com.proj.wsf.model.DomainEntity;
import org.springframework.stereotype.Service;

/**
 * Description the class  ComplementaryEntityActive - Classe que implementa o método
 process do contrato com IStrategy.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
@Service("generateToken")
public class GenerateToken implements IStrategy {

    /**
     * Método que realiza o process do método strategy,
 Adiciona ativo na entidade passada por parametro.
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
                
        String token = JWTUtilToken.criarToken(entity.getUser());
        entity.setTk(token);
        return null;
    }

}


