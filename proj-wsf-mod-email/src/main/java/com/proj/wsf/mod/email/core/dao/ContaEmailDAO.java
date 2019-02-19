/*
 * ContaEmailDAO.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.mod.email.model.ContaEmail;
import com.proj.wsf.mod.email.model.ContaEmail_;
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
 * Description the class  ContaEmailDAO - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Repository("ContaEmailDAO")
public class ContaEmailDAO extends DAOImp<ContaEmail> implements IDAO<ContaEmail> {

    /**
     * Método que consulta todos os acões, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List ContaEmail
     */
    @Override
    public List<ContaEmail> findByMaxList(final int begin, final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<ContaEmail> query = builder.createQuery(ContaEmail.class);

        final TypedQuery<ContaEmail> typedQuery = this.em.createQuery(
                query.select(
                        query.from(ContaEmail.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        return (List<ContaEmail>) typedQuery.getResultList();

    }

    /**
     * Método que consulta tipoEmail de acordo com os atributos preenchidos.
     *
     * @param contaEmail
     * @return List ContaEmail
     */
    @Override
    public List<ContaEmail> findByCriteria(final ContaEmail contaEmail) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<ContaEmail> query = builder.createQuery(ContaEmail.class);
        final Root from = query.from(ContaEmail.class);

        Predicate predicate = builder.and();

        if (contaEmail.getIdentifierCE() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ContaEmail_.IDENTIFIER_CE), contaEmail.getIdentifierCE()));
        }
        
        if (contaEmail.getUsuario() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ContaEmail_.USUARIO), contaEmail.getUsuario()));
        }

        if (contaEmail.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ContaEmail_.INCLUDED_IN), new DateTime(contaEmail.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (contaEmail.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ContaEmail_.CHANGED_IN), new DateTime(contaEmail.getChangedIn(), DateTimeZone.UTC)));
        }

        if (contaEmail.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ContaEmail_.CHANGED_BY), contaEmail.getIncludedBy()));
        }

        if (contaEmail.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ContaEmail_.CHANGED_BY), contaEmail.getChangedBy()));
        }

        final TypedQuery<ContaEmail> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(ContaEmail_.IDENTIFIER_CE)))
        );

        return (List<ContaEmail>) typedQuery.getResultList();
    }

    /**
     * Método para desativar ao inves de deletar a entidade
     *
     * @param entity
     */
    @Override
    public void delete(ContaEmail entity) {
        entity.desativarDomainEntity();
        super.delete(entity);
    }

}

