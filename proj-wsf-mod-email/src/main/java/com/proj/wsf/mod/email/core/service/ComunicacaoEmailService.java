/*
 * ComunicacaoEmailService.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.core.service;

import com.proj.wsf.mod.email.core.strategy.ComunicacaoEmailStrategy;
import com.proj.wsf.core.IRepository;
import com.proj.wsf.core.IServico;
import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.service.impl.AbstractService;
import com.proj.wsf.mod.email.core.repository.ComunicacaoEmailRepository;
import com.proj.wsf.mod.email.model.ComunicacaoEmail;
import com.proj.wsf.model.anotations.ADomainEntity;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Description the class  ComunicacaoEmailService - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Service("comunicacaoEmailService")
@ADomainEntity(nome = "comunicacaoEmail", classe = ComunicacaoEmail.class)
public class ComunicacaoEmailService extends AbstractService implements IServico {

    @Autowired
    @Qualifier(value = "comunicacaoEmailRepository")
    ComunicacaoEmailRepository comunicacaoEmailRepository;

    @Autowired
    @Qualifier(value = "comunicacaoEmailStrategy")
    ComunicacaoEmailStrategy comunicacaoEmailStrategy;

    @Override
    public IRepository getRepository() {
        return comunicacaoEmailRepository;
    }

    @Override
    public Map<String, List<IStrategy>> getStrategys() {
        return comunicacaoEmailStrategy.getRnsComunicacaoEmail();
    }

}
