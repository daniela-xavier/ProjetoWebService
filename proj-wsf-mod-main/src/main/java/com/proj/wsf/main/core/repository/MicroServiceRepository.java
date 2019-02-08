/*
 * MicroServiceRepository.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.main.core.repository;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.main.core.dao.MicroServiceDAO;
import com.proj.wsf.main.model.MicroService;
import com.proj.wsf.model.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Transient;
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

    /**
     * Classe de persistencia de dados
     */
    @Autowired
    @Qualifier(value = "microServiceDAO")
    @Transient
    private MicroServiceDAO microServiceDAO;

    /**
     * Método que salva a entity fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> save(DomainEntity entity) {
        final MicroService ms = (MicroService) entity;
        microServiceDAO.save(ms);
        return returnEntitys(ms);
    }

    /**
     * Método que altera a entidade fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> update(DomainEntity entity) {
        final MicroService ms = (MicroService) entity;
        this.microServiceDAO.update(ms);
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
     * Método que desativa a entidade, por meio do id fornecido no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> disable(DomainEntity entity) {
        MicroService ms = (MicroService) entity;
        this.microServiceDAO.delete(ms);
        return returnEntitys(entity);
    }
    
    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findByFilter(DomainEntity entity) {
        final MicroService ms = (MicroService) entity;
        List<MicroService> entitys = this.microServiceDAO.findByCriteria(ms);
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

