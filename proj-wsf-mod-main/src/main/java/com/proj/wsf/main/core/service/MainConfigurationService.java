/*
 * MainConfigurationService.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.main.core.service;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.core.IServico;
import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.service.impl.AbstractService;
import com.proj.wsf.main.core.repository.MainConfigurationRepository;
import com.proj.wsf.main.core.strategy.MainConfigurationStrategy;
import com.proj.wsf.main.model.MainConfiguration;
import com.proj.wsf.model.anotations.ADomainEntity;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Description the class  MainConfigurationService - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */

@Service("mainConfigurationService")
@ADomainEntity(nome = "MainConfiguration", classe = MainConfiguration.class)
public class MainConfigurationService extends AbstractService implements IServico {

    @Autowired
    @Qualifier(value = "mainConfigurationRepository")
    MainConfigurationRepository mainConfigurationRepository;

    @Autowired
    @Qualifier(value = "mainConfigurationStrategy")
    MainConfigurationStrategy mainConfigurationStrategy;

    @Override
    public IRepository getRepository() {
        return mainConfigurationRepository;
    }

    @Override
    public Map<String, List<IStrategy>> getStrategys() {
        return mainConfigurationStrategy.getRnsMainConfiguration();
    }

}
