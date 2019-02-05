/*
 * DAOImp.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.core.dao.impl;

import com.proj.wsf.core.IDAO;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * Description the class  DAOImp - - Classe que implementa os métodos de IDAO,
 Tornando os mesmos executaveis de modo génerico, as especificações mais detalhadas
 são implementados nas classes filhas de DAOImp.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public abstract class DAOImp<DomainEntity> implements IDAO<DomainEntity> {

    @PersistenceContext
    protected EntityManager em;

    private Class<DomainEntity> type;

    /**
     * Construtor da classe que atribui o tipo da classe implementada pelo
     * contrato.
     */
    public DAOImp() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    /**
     * Método que realiza a pesquisa de entity por id.
     *
     * @param id
     * @return domainEntity
     */
    @Override
    public DomainEntity findOne(long id) {
        return (DomainEntity) this.em.find(type, id);
    }

    /**
     * Método de pesquisa de todas as entitys.
     *
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findAll() {
        return this.em.createQuery("from " + type.getSimpleName()).getResultList();
    }

    /**
     * Método de pesquisa de todas as entitys, com o valor de inicio e fim da
     * lista.
     *
     * @param begin
     * @param end
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findByMaxList(int begin, int end) {
        Session session = (Session) this.em.getDelegate();
        Criteria crit = session.createCriteria(type.getClass());

        List<DomainEntity> result = new ArrayList<DomainEntity>();
        crit.setFirstResult(begin);
        crit.setMaxResults(end);
        result = crit.list();

        return result;
    }

    /**
     * Método de pesquisa de entity por critérios.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findByCriteria(DomainEntity entity) {
        return null;
    }

    /**
     * Método que salva a entity.
     *
     * @param entity
     */
    @Override
    public void save(DomainEntity entity) {
        this.em.persist(entity);
    }

    /**
     * Método que atualiza entity.
     *
     * @param entity
     * @return domainEntity
     */
    @Override
    public DomainEntity update(final DomainEntity entity) {
        return (DomainEntity) this.em.merge(entity);
    }

    /**
     * Método que deleta a entity.
     *
     * @param entity
     */
    @Override
    public void delete(DomainEntity entity) {
        //this.em.remove(entity);
        this.em.merge(entity);
    }

    /**
     * Método que deleta a entity por id.
     *
     * @param id
     */
    @Override
    public void deleteById(final long id) {
        final DomainEntity entity = findOne(id);
        delete(entity);
    }

}

