/*
 * ActDAO.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.main.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.main.model.Act;
import com.proj.wsf.main.model.Act_;
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
    public List<Act> findByMaxList(final int begin, final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<Act> query = builder.createQuery(Act.class);

        final TypedQuery<Act> typedQuery = this.em.createQuery(
                query.select(
                        query.from(Act.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

         return (List<Act>) typedQuery.getResultList();

    }

    /**
     * Método que consulta acao de acordo com os atributos preenchidos.
     *
     * @param acao
     * @return List<Act>
     */
    @Override
    public List<Act> findByCriteria(final Act acao) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<Act> query = builder.createQuery(Act.class);
        Root from = query.from(Act.class);

        Predicate predicate = builder.and();

        if (acao.getIdentifier() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Act_.IDENTIFIER), acao.getIdentifier()));
        }

        if (acao.getNome() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Act_.NOME), acao.getNome()));
        }

        if (acao.getDescricao() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Act_.DESCRICAO), acao.getDescricao()));
        }

        if (acao.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Act_.INCLUDED_IN), new DateTime(acao.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (acao.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Act_.CHANGED_IN), new DateTime(acao.getChangedIn(), DateTimeZone.UTC)));
        }

        if (acao.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Act_.CHANGED_BY), acao.getIncludedBy()));
        }

        if (acao.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Act_.CHANGED_BY), acao.getChangedBy()));
        }

        final TypedQuery<Act> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(Act_.IDENTIFIER)))
        );

        
        return (List<Act>) typedQuery.getResultList();
    }

}
