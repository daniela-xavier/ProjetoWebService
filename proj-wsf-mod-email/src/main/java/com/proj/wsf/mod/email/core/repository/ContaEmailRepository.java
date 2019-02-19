/*
 * ContaEmailRepository.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.core.repository;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.mod.email.core.dao.ContaEmailDAO;
import com.proj.wsf.mod.email.model.ContaEmail;
import com.proj.wsf.model.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Description the class  ContaEmailRepository - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Component("contaEmailRepository")
public class ContaEmailRepository implements IRepository {

    /**
     * Classe de persistencia de dados
     */
    @Autowired
    @Qualifier(value = "contaEmailDAO")
    @Transient
    private ContaEmailDAO contaEmailDAO;

    /**
     * Método que salva a entity fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> save(DomainEntity entity) {
        if (entity instanceof ContaEmail) {
            final ContaEmail contaEmail = (ContaEmail) entity;
            contaEmailDAO.save(contaEmail);
            return returnEntitys(contaEmail);
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
        if (entity instanceof ContaEmail) {
            final ContaEmail contaEmail = (ContaEmail) entity;
            this.contaEmailDAO.update(contaEmail);
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

        ContaEmail contaEmail = this.contaEmailDAO.findOne(id);
        this.contaEmailDAO.deleteById(id);
        return returnEntitys(contaEmail);

    }

    /**
     * Método que desativa a entidade, por meio do id fornecido no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> disable(DomainEntity entity) {
        if (entity instanceof ContaEmail) {
            final ContaEmail contaEmail = (ContaEmail) entity;
            this.contaEmailDAO.delete(contaEmail);
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
        if (entity instanceof ContaEmail) {
            final ContaEmail contaEmail = (ContaEmail) entity;
            List<ContaEmail> entitys = this.contaEmailDAO.findByCriteria(contaEmail);
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
        List<ContaEmail> entitys = this.contaEmailDAO.findAll();
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
        ContaEmail contaEmail = this.contaEmailDAO.findOne(id);
        return returnEntitys(contaEmail);
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
    public List<DomainEntity> returnEntitys(List<ContaEmail> entitys) {
        List<DomainEntity> ents = new ArrayList<DomainEntity>();
        ents.addAll(entitys);
        return ents;
    }

}

