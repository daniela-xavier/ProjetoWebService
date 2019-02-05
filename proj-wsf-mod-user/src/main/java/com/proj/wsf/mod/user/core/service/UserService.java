/*
 * UserService.java
 *
 * Created on 05-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.mod.user.core.service;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.core.IServico;
import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.service.impl.AbstractService;
import com.proj.wsf.mod.user.core.repository.UserRepository;
import com.proj.wsf.mod.user.core.strategy.UserStrategy;
import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.model.anotations.ADomainEntity;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Description the class  UserService - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 05/02/2019
 */
@Component
@Service("userService")
@ADomainEntity(nome = "User", classe = User.class)
public class UserService extends AbstractService implements IServico {

    @Autowired
    @Qualifier(value = "userRepository")
    UserRepository userRepository;

    @Autowired
    @Qualifier(value = "userStrategy")
    UserStrategy userStrategy;

    @Override
    public IRepository getRepository() {
        return userRepository;
    }

    @Override
    public Map<String, List<IStrategy>> getStrategys() {
        return userStrategy.getRnsUser();
    }

}

