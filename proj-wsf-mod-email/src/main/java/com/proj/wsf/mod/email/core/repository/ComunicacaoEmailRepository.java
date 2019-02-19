/*
 * ComunicacaoEmailRepository.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.core.repository;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.mod.email.core.dao.ComunicacaoEmailDAO;
import com.proj.wsf.mod.email.model.ComunicacaoEmail;
import com.proj.wsf.model.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Description the class  ComunicacaoEmailRepository - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Component("comunicacaoEmailRepository")
public class ComunicacaoEmailRepository implements IRepository {

    /**
     * Classe de persistencia de dados
     */
    @Autowired
    @Qualifier(value = "comunicacaoEmailDAO")
    @Transient
    private ComunicacaoEmailDAO comunicacaoEmailDAO;

    /**
     * Método que salva a entity fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> save(DomainEntity entity) {
        if (entity instanceof ComunicacaoEmail) {
            final ComunicacaoEmail comunicacaoEmail = (ComunicacaoEmail) entity;
            comunicacaoEmailDAO.save(comunicacaoEmail);
            return returnEntitys(comunicacaoEmail);
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
        if (entity instanceof ComunicacaoEmail) {
            final ComunicacaoEmail comunicacaoEmail = (ComunicacaoEmail) entity;
            this.comunicacaoEmailDAO.update(comunicacaoEmail);
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

        ComunicacaoEmail comunicacaoEmail = this.comunicacaoEmailDAO.findOne(id);
        this.comunicacaoEmailDAO.deleteById(id);
        return returnEntitys(comunicacaoEmail);

    }

    /**
     * Método que desativa a entidade, por meio do id fornecido no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> disable(DomainEntity entity) {
        if (entity instanceof ComunicacaoEmail) {
            final ComunicacaoEmail comunicacaoEmail = (ComunicacaoEmail) entity;
            this.comunicacaoEmailDAO.delete(comunicacaoEmail);
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
        if (entity instanceof ComunicacaoEmail) {
            final ComunicacaoEmail comunicacaoEmail = (ComunicacaoEmail) entity;
            List<ComunicacaoEmail> entitys = this.comunicacaoEmailDAO.findByCriteria(comunicacaoEmail);
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
        List<ComunicacaoEmail> entitys = this.comunicacaoEmailDAO.findAll();
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
        ComunicacaoEmail comunicacaoEmail = this.comunicacaoEmailDAO.findOne(id);
        return returnEntitys(comunicacaoEmail);
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
    public List<DomainEntity> returnEntitys(List<ComunicacaoEmail> entitys) {
        List<DomainEntity> ents = new ArrayList<DomainEntity>();
        ents.addAll(entitys);
        return ents;
    }

}

