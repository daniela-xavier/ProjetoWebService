/*
 * UserRepository.java
 *
 * Created on 05-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.mod.user.core.repository;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.mod.user.core.dao.UserDAO;
import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.model.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Description the class  UserRepository - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 05/02/2019
 */
@Component("userRepository")
public class UserRepository implements IRepository {

    @Autowired
    @Qualifier(value = "userDAO")
    UserDAO userDAO;

    /**
     * Método que salva a entity fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> save(DomainEntity entity) {
        User usuario = (User) entity;
        userDAO.save(usuario);
        return returnEntitys(usuario);
    }

    /**
     * Método que altera a entidade fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> update(DomainEntity entity) {
        User usuario = (User) entity;
        this.userDAO.update(usuario);
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
        User act = this.userDAO.findOne(id);
        this.userDAO.deleteById(id);
        return returnEntitys(act);
    }

     /**
     * Método que desabilita a entidade fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> disable(DomainEntity entity) {
        User usuario = (User) entity;
        this.userDAO.delete(usuario);
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
        User usuario = (User) entity;
        List<User> entitys = this.userDAO.findByCriteria(usuario);
        return returnEntitys(entitys);
    }

    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findAll() {
        List<User> entitys = this.userDAO.findAll();
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
        User act = this.userDAO.findOne(id);
        return returnEntitys(act);
    }

    /**
     * Método que retorna a entidade de modo correto.
     * 
     * @param entity
     * @return List<DomainEntity>
     */
    public List<DomainEntity> returnEntitys(DomainEntity entity) {
        List<DomainEntity> entitys = new ArrayList<DomainEntity>();
        entitys.add(entity);
        return entitys;
    }

    /**
     *  Método que adiciona a entidade a lista de entidades correta.
     * 
     * @param entitys
     * @return List<DomainEntity>
     */
    public List<DomainEntity> returnEntitys(List<User> entitys) {
        List<DomainEntity> ents = new ArrayList<DomainEntity>();
        ents.addAll(entitys);
        return ents;
    }
}

