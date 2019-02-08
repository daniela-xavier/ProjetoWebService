/*
 * MainConfigurationRepository.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.main.core.repository;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.main.core.dao.MainConfigurationDAO;
import com.proj.wsf.main.model.MainConfiguration;
import com.proj.wsf.model.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Description the class MainConfigurationRepository - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("mainConfigurationRepository")
public class MainConfigurationRepository implements IRepository {

    /**
     * Classe de persistencia de dados
     */
    @Autowired
    @Qualifier(value = "mainConfigurationDAO")
    @Transient
    private MainConfigurationDAO mainConfigurationDAO;

    /**
     * Método que salva a entity fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> save(DomainEntity entity) {
        final MainConfiguration mc = (MainConfiguration) entity;
        mainConfigurationDAO.save(mc);
        return returnEntitys(mc);
    }

    /**
     * Método que altera a entidade fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> update(DomainEntity entity) {
        final MainConfiguration mc = (MainConfiguration) entity;
        this.mainConfigurationDAO.update(mc);
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
        MainConfiguration MainConfiguration = this.mainConfigurationDAO.findOne(id);
        this.mainConfigurationDAO.deleteById(id);
        return returnEntitys(MainConfiguration);
    }

    /**
     * Método que desativa a entidade, por meio do id fornecido no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> disable(DomainEntity entity) {
        MainConfiguration mc = (MainConfiguration) entity;
        this.mainConfigurationDAO.delete(mc);
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
        final MainConfiguration mc = (MainConfiguration) entity;
        List<MainConfiguration> entitys = this.mainConfigurationDAO.findByCriteria(mc);
        return returnEntitys(entitys);
    }

    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findAll() {
        List<MainConfiguration> entitys = this.mainConfigurationDAO.findAll();
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
        MainConfiguration MainConfiguration = this.mainConfigurationDAO.findOne(id);
        return returnEntitys(MainConfiguration);
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
    public List<DomainEntity> returnEntitys(List<MainConfiguration> entitys) {
        List<DomainEntity> ents = new ArrayList<DomainEntity>();
        ents.addAll(entitys);
        return ents;
    }

}
