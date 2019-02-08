/*
 * MicroServiceService.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.main.core.service;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.core.IServico;
import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.service.impl.AbstractService;
import com.proj.wsf.main.core.repository.MicroServiceRepository;
import com.proj.wsf.main.core.strategy.MicroServiceStrategy;
import com.proj.wsf.main.model.MicroService;
import com.proj.wsf.model.anotations.ADomainEntity;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Description the class  MicroServiceService - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */

@Service("microServiceService")
@ADomainEntity(nome = "MicroService", classe = MicroService.class)
public class MicroServiceService extends AbstractService implements IServico {

    @Autowired
    @Qualifier(value = "microServiceRepository")
    MicroServiceRepository microServiceRepository;

    @Autowired
    @Qualifier(value = "microServiceStrategy")
    MicroServiceStrategy microServiceStrategy;

    @Override
    public IRepository getRepository() {
        return microServiceRepository;
    }

    @Override
    public Map<String, List<IStrategy>> getStrategys() {
        return microServiceStrategy.getRnsMicroService();
    }

}
