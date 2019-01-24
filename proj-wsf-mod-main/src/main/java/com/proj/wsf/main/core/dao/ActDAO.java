/*
 * ActDAO.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.main.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.main.model.Act;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Description the class ActDAO - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("actDAO")
@Repository
public class ActDAO extends DAOImp<Act> implements IDAO<Act> {

    /**
     * Método que consulta todos os acões, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List<Act>
     */
    @Override
    public List<Act> findByMaxList(int begin, int end) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Act> query = builder.createQuery(Act.class);

        TypedQuery<Act> typedQuery = this.em.createQuery(
                query.select(
                        query.from(Act.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        List<Act> results = typedQuery.getResultList();
        return results;

    }

    /**
     * Método que consulta acao de acordo com os atributos preenchidos.
     *
     * @param acao
     * @return List<Act>
     */
    @Override
    public List<Act> findByCriteria(Act acao) {

        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Act> query = builder.createQuery(Act.class);
        Root from = query.from(Act.class);

        Predicate predicate = builder.and();

        /*if (acao.getId() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Long>get("id"), acao.getId()));
        }
    

        if (acao.getNomr() != null) {
        predicate = builder.and(predicate,
        builder.equal(from.<String>get("nome"), acao.getNome()));
        }*/
        if (acao.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("includedIn"), new DateTime(acao.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (acao.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("changedIn"), new DateTime(acao.getChangedIn(), DateTimeZone.UTC)));
        }

        if (acao.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("includedBy"), (acao.getIncludedBy())));
        }

        if (acao.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("chancedBy"), (acao.getChangedBy())));
        }

        TypedQuery<Act> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get("id")))
        );

        List<Act> results = typedQuery.getResultList();
        return results;
    }

}
