/*
 * TemplateHtmlService.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.core.service;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.core.IServico;
import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.service.impl.AbstractService;
import com.proj.wsf.mod.email.core.repository.TemplateHtmlRepository;
import com.proj.wsf.mod.email.core.strategy.TemplateHtmlStrategy;
import com.proj.wsf.mod.email.model.TemplateHtml;
import com.proj.wsf.model.anotations.ADomainEntity;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Description the class  TemplateHtmlService - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Service("templateHtmlService")
@ADomainEntity(nome = "templateHtml", classe = TemplateHtml.class)
public class TemplateHtmlService extends AbstractService implements IServico {

    @Autowired
    @Qualifier(value = "templateHtmlRepository")
    TemplateHtmlRepository templateHtmlRepository;

    @Autowired
    @Qualifier(value = "templateHtmlStrategy")
    TemplateHtmlStrategy templateHtmlStrategy;

    @Override
    public IRepository getRepository() {
        return templateHtmlRepository;
    }

    @Override
    public Map<String, List<IStrategy>> getStrategys() {
        return templateHtmlStrategy.getRnsTemplateHtml();
    }
}
