/*
 * RetornoFalhaEmailDAO.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.mod.email.model.RetornoFalhaEmail;
import com.proj.wsf.mod.email.model.RetornoFalhaEmail_;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Repository;

/**
 * Description the class  RetornoFalhaEmailDAO - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Repository("retornoFalhaEmailDAO")
public class RetornoFalhaEmailDAO extends DAOImp<RetornoFalhaEmail> implements IDAO<RetornoFalhaEmail> {

    /**
     * Método que consulta todos os acões, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List RetornoFalhaEmail
     */
    @Override
    public List<RetornoFalhaEmail> findByMaxList(final int begin, final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<RetornoFalhaEmail> query = builder.createQuery(RetornoFalhaEmail.class);

        final TypedQuery<RetornoFalhaEmail> typedQuery = this.em.createQuery(
                query.select(
                        query.from(RetornoFalhaEmail.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        return (List<RetornoFalhaEmail>) typedQuery.getResultList();

    }

    /**
     * Método que consulta tipoEmail de acordo com os atributos preenchidos.
     *
     * @param retornoFalhaEmail
     * @return List RetornoFalhaEmail
     */
    @Override
    public List<RetornoFalhaEmail> findByCriteria(final RetornoFalhaEmail retornoFalhaEmail) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<RetornoFalhaEmail> query = builder.createQuery(RetornoFalhaEmail.class);
        final Root from = query.from(RetornoFalhaEmail.class);

        Predicate predicate = builder.and();

        if (retornoFalhaEmail.getCodigo() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(RetornoFalhaEmail_.CODIGO), retornoFalhaEmail.getCodigo()));
        }

        if (retornoFalhaEmail.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(RetornoFalhaEmail_.INCLUDED_IN), new DateTime(retornoFalhaEmail.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (retornoFalhaEmail.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(RetornoFalhaEmail_.CHANGED_IN), new DateTime(retornoFalhaEmail.getChangedIn(), DateTimeZone.UTC)));
        }

        if (retornoFalhaEmail.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(RetornoFalhaEmail_.CHANGED_BY), retornoFalhaEmail.getIncludedBy()));
        }

        if (retornoFalhaEmail.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(RetornoFalhaEmail_.CHANGED_BY), retornoFalhaEmail.getChangedBy()));
        }

        final TypedQuery<RetornoFalhaEmail> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(RetornoFalhaEmail_.IDENTIFIER_EE_R)))
        );

        return (List<RetornoFalhaEmail>) typedQuery.getResultList();
    }

    /**
     * Método para desativar ao inves de deletar a entidade
     *
     * @param entity
     */
    @Override
    public void delete(RetornoFalhaEmail entity) {
        entity.desativarDomainEntity();
        super.delete(entity);
    }

}
