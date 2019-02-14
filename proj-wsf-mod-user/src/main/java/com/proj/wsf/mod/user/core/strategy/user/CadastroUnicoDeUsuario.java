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
import com.proj.wsf.mod.user.core.repository.UserRepository;
import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.model.DomainEntity;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Description the class CadastroUnicoDeUsuario - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 08/02/2019
 */
@Service("cadastroUnicoDeUsuario")
public class CadastroUnicoDeUsuario implements IStrategy {

    @Autowired
    @Qualifier(value = "userRepository")
    private UserRepository userRepository;

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
            User user = (User) entity;
            User userfind = new User(user.getUsuario(), user.getEmail());
            List<DomainEntity> result = userRepository.findByFilter(userfind);

            if (result.size() > 0) {
                return "<> Usuario já consta como cadastrado.";                
            }
            
            return null;
        }

        return "Entidade inválida. Não é possível executar esta ação.";
    }
    
     @Override
    public String toString() {
        return this.getClass().getSimpleName(); 
    }
}
