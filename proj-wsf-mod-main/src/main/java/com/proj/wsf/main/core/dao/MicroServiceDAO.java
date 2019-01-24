/*
 * MicroServiceDAO.java
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
import com.proj.wsf.main.model.MicroService;
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
 * Description the class  MicroServiceDAO - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("microServiceDAO")
@Repository
public class MicroServiceDAO extends DAOImp<MicroService> implements IDAO<MicroService> {

    /**
     * Método que consulta todos os MicroService, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List<MicroService>
     */
    @Override
    public List<MicroService> findByMaxList(int begin, int end) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<MicroService> query = builder.createQuery(MicroService.class);

        TypedQuery<MicroService> typedQuery = this.em.createQuery(
                query.select(
                        query.from(MicroService.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        List<MicroService> results = typedQuery.getResultList();
        return results;

    }

    /**
     * Método que consulta MicroService de acordo com os atributos preenchidos.
     *
     * @param microService
     * @return List<MicroService>
     */
    @Override
    public List<MicroService> findByCriteria(MicroService microService) {

        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<MicroService> query = builder.createQuery(MicroService.class);
        Root from = query.from(MicroService.class);

        Predicate predicate = builder.and();

        /*if (microService.getId() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Long>get("id"), microService.getId()));
        }
    

        if (microService.getNomr() != null) {
        predicate = builder.and(predicate,
        builder.equal(from.<String>get("nome"), microService.getNome()));
        }*/
        if (microService.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("includedIn"), new DateTime(microService.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (microService.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("changedIn"), new DateTime(microService.getChangedIn(), DateTimeZone.UTC)));
        }

        if (microService.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("includedBy"), (microService.getIncludedBy())));
        }

        if (microService.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("chancedBy"), (microService.getChangedBy())));
        }

        TypedQuery<MicroService> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get("id")))
        );

        List<MicroService> results = typedQuery.getResultList();
        return results;
    }

}
