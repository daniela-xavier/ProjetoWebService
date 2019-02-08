/*
 * ActRepository.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.main.core.repository;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.main.core.dao.ActDAO;
import com.proj.wsf.main.model.Act;
import com.proj.wsf.model.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Description the class ActRepository - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("actRepository")
public class ActRepository implements IRepository {

    /**
     * Classe de persistencia de dados
     */
    @Autowired
    @Qualifier(value = "actDAO")
    @Transient
    private ActDAO actDAO;

    /**
     * Método que salva a entity fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> save(DomainEntity entity) {
        if (entity instanceof Act) {
            final Act acao = (Act) entity;
            actDAO.save(acao);
            return returnEntitys(acao);
        }
        return null;
    }

    /**
     * Método que altera a entidade fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> update(DomainEntity entity) {
        if (entity instanceof Act) {
            final Act acao = (Act) entity;
            this.actDAO.update(acao);
            return returnEntitys(entity);
        }
        return null;
    }

    /**
     * Método que deleta a entidade, por meio do id fornecido no método.
     *
     * @param id
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> delete(Long id) {

        Act act = this.actDAO.findOne(id);
        this.actDAO.deleteById(id);
        return returnEntitys(act);

    }

    /**
     * Método que desativa a entidade, por meio do id fornecido no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> disable(DomainEntity entity) {
        if (entity instanceof Act) {
            final Act acao = (Act) entity;
            this.actDAO.delete(acao);
            return returnEntitys(entity);
        }
        return null;
    }

    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findByFilter(DomainEntity entity) {
        if (entity instanceof Act) {
            final Act acao = (Act) entity;
            List<Act> entitys = this.actDAO.findByCriteria(acao);
            return returnEntitys(entitys);
        }
        return null;
    }

    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findAll() {
        List<Act> entitys = this.actDAO.findAll();
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
        Act act = this.actDAO.findOne(id);
        return returnEntitys(act);
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
    public List<DomainEntity> returnEntitys(List<Act> entitys) {
        List<DomainEntity> ents = new ArrayList<DomainEntity>();
        ents.addAll(entitys);
        return ents;
    }

}
