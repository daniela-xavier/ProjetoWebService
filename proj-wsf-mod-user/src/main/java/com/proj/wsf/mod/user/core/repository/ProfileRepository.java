/*
 * ProfileRepository.java
 *
 * Created on 05-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.mod.user.core.repository;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.mod.user.core.dao.ProfileDAO;
import com.proj.wsf.mod.user.model.Profile;
import com.proj.wsf.model.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Description the class  ProfileRepository - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 05/02/2019
 */
@Component("profileRepository")
public class ProfileRepository implements IRepository {

    @Autowired
    @Qualifier(value = "profileDAO")
    ProfileDAO profileDAO;

    /**
     * Método que salva a entity fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> save(DomainEntity entity) {
        Profile perfil = (Profile) entity;
        profileDAO.save(perfil);
        return returnEntitys(perfil);
    }

    /**
     * Método que altera a entidade fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> update(DomainEntity entity) {
        Profile perfil = (Profile) entity;
        this.profileDAO.update(perfil);
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
        Profile act = this.profileDAO.findOne(id);
        this.profileDAO.deleteById(id);
        return returnEntitys(act);
    }

    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findByFilter(DomainEntity entity) {
        Profile perfil = (Profile) entity;
        List<Profile> entitys = this.profileDAO.findByCriteria(perfil);
        return returnEntitys(entitys);
    }

    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findAll() {
        List<Profile> entitys = this.profileDAO.findAll();
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
        Profile act = this.profileDAO.findOne(id);
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
    public List<DomainEntity> returnEntitys(List<Profile> entitys) {
        List<DomainEntity> ents = new ArrayList<DomainEntity>();
        ents.addAll(entitys);
        return ents;
    }

}

