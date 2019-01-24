/*
 * MainConfigurationDAO.java
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
import com.proj.wsf.main.model.MainConfiguration;
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
 * Description the class  MainConfigurationDAO - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("mainConfigurationDAO")
@Repository
public class MainConfigurationDAO extends DAOImp<MainConfiguration> implements IDAO<MainConfiguration> {

    /**
     * Método que consulta todos os MainConfigurations, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List<MainConfiguration>
     */
    @Override
    public List<MainConfiguration> findByMaxList(int begin, int end) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<MainConfiguration> query = builder.createQuery(MainConfiguration.class);

        TypedQuery<MainConfiguration> typedQuery = this.em.createQuery(
                query.select(
                        query.from(MainConfiguration.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        List<MainConfiguration> results = typedQuery.getResultList();
        return results;

    }

    /**
     * Método que consulta MainConfiguration de acordo com os atributos preenchidos.
     *
     * @param mc
     * @return List<MainConfiguration>
     */
    @Override
    public List<MainConfiguration> findByCriteria(MainConfiguration mc) {

        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<MainConfiguration> query = builder.createQuery(MainConfiguration.class);
        Root from = query.from(MainConfiguration.class);

        Predicate predicate = builder.and();

        /*if (mc.getId() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Long>get("id"), mc.getId()));
        }
    

        if (mc.getNomr() != null) {
        predicate = builder.and(predicate,
        builder.equal(from.<String>get("nome"), mc.getNome()));
        }*/
        if (mc.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("includedIn"), new DateTime(mc.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (mc.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("changedIn"), new DateTime(mc.getChangedIn(), DateTimeZone.UTC)));
        }

        if (mc.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("includedBy"), (mc.getIncludedBy())));
        }

        if (mc.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("chancedBy"), (mc.getChangedBy())));
        }

        TypedQuery<MainConfiguration> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get("id")))
        );

        List<MainConfiguration> results = typedQuery.getResultList();
        return results;
    }

}
