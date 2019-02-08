/*
 * MicroServiceDAO.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.main.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.main.model.MicroService;
import com.proj.wsf.main.model.MicroService_;
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
 * Description the class MicroServiceDAO - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("microServiceDAO")
@Repository
public class MicroServiceDAO extends DAOImp<MicroService> implements IDAO<MicroService> {

    /**
     * Método que consulta todos os MicroService, porém retorna no numero
     * inicial ao numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List<MicroService>
     */
    @Override
    public List<MicroService> findByMaxList(final int begin, final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<MicroService> query = builder.createQuery(MicroService.class);

        final TypedQuery<MicroService> typedQuery = this.em.createQuery(
                query.select(
                        query.from(MicroService.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit
      
        return (List<MicroService>) typedQuery.getResultList();

    }

    /**
     * Método que consulta MicroService de acordo com os atributos preenchidos.
     *
     * @param microService
     * @return List<MicroService>
     */
    @Override
    public List<MicroService> findByCriteria(final MicroService microService) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<MicroService> query = builder.createQuery(MicroService.class);
        Root from = query.from(MicroService.class);

        Predicate predicate = builder.and();

        if (microService.getIdentifier() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MicroService_.IDENTIFIER), microService.getIdentifier()));
        }

        if (microService.getNome() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MicroService_.NOME), microService.getNome()));
        }
        
        if (microService.getDescricao()!= null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MicroService_.DESCRICAO), microService.getDescricao()));
        }
        
        if (microService.getFluxo()!= null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MicroService_.FLUXO), microService.getFluxo()));
        }

        if (microService.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MicroService_.INCLUDED_IN), new DateTime(microService.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (microService.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MicroService_.CHANGED_IN), new DateTime(microService.getChangedIn(), DateTimeZone.UTC)));
        }

        if (microService.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MicroService_.INCLUDED_BY), microService.getIncludedBy()));
        }

        if (microService.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MicroService_.CHANGED_BY), microService.getChangedBy()));
        }

        final TypedQuery<MicroService> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(MicroService_.IDENTIFIER)))
        );

        return (List<MicroService>) typedQuery.getResultList();
    }

}
