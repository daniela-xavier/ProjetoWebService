/*
 * MicroServiceRepository.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.main.core.repository;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.main.core.dao.MicroServiceDAO;
import com.proj.wsf.main.model.MicroService;
import com.proj.wsf.model.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Description the class  MicroServiceRepository - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("microServiceRepository")
public class MicroServiceRepository implements IRepository {

    @Autowired
    @Qualifier(value = "microServiceDAO")
    MicroServiceDAO microServiceDAO;

    /**
     * Método que salva a entity fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> save(DomainEntity entity) {
        MicroService u = (MicroService) entity;
        microServiceDAO.save(u);
        return returnEntitys(u);
    }

    /**
     * Método que altera a entidade fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> update(DomainEntity entity) {
        MicroService u = (MicroService) entity;
        this.microServiceDAO.update(u);
        return returnEntitys(entity);
    }

    /**
     * Método que deleta a entidade, por meio do id fornecido no método.
     *
     * @param id
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> delete(Long id) {
        MicroService microService = this.microServiceDAO.findOne(id);
        this.microServiceDAO.deleteById(id);
        return returnEntitys(microService);
    }

    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findByFilter(DomainEntity entity) {
        MicroService u = (MicroService) entity;
        List<MicroService> entitys = this.microServiceDAO.findByCriteria(u);
        return returnEntitys(entitys);
    }

    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findAll() {
        List<MicroService> entitys = this.microServiceDAO.findAll();
        return returnEntitys(entitys);
    }

    /**
     * Método que busca a entidade, por meio do id fornecido.
     *
     * @param id
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findById(Long id) {
        MicroService microService = this.microServiceDAO.findOne(id);
        return returnEntitys(microService);
    }

    /**
     * 
     * @param entity
     * @return 
     */
    public List<DomainEntity> returnEntitys(DomainEntity entity) {
        List<DomainEntity> entitys = new ArrayList<DomainEntity>();
        entitys.add(entity);
        return entitys;
    }

    /**
     * 
     * @param entitys
     * @return 
     */
    public List<DomainEntity> returnEntitys(List<MicroService> entitys) {
        List<DomainEntity> ents = new ArrayList<DomainEntity>();
        ents.addAll(entitys);
        return ents;
    }

}

