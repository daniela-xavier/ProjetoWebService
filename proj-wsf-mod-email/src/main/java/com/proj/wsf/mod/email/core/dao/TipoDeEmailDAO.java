/*
 * TipoDeEmailDAO.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */
package com.proj.wsf.mod.email.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.mod.email.model.TemplateHtml_;
import com.proj.wsf.mod.email.model.TipoDeEmail;
import com.proj.wsf.mod.email.model.TipoDeEmail_;
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
 * Description the class TipoDeEmailDAO - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 19/02/2019
 */
@Repository("tipoEmailDAO")
public class TipoDeEmailDAO extends DAOImp<TipoDeEmail> implements IDAO<TipoDeEmail> {

    /**
     * Método que consulta todos os acões, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List TipoDeEmail
     */
    @Override
    public List<TipoDeEmail> findByMaxList(final int begin, final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<TipoDeEmail> query = builder.createQuery(TipoDeEmail.class);

        final TypedQuery<TipoDeEmail> typedQuery = this.em.createQuery(
                query.select(
                        query.from(TipoDeEmail.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        return (List<TipoDeEmail>) typedQuery.getResultList();

    }

    /**
     * Método que consulta tipoEmail de acordo com os atributos preenchidos.
     *
     * @param tipoEmail
     * @return List TipoDeEmail
     */
    @Override
    public List<TipoDeEmail> findByCriteria(final TipoDeEmail tipoEmail) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<TipoDeEmail> query = builder.createQuery(TipoDeEmail.class);
        final Root from = query.from(TipoDeEmail.class);

        Predicate predicate = builder.and();

        if (tipoEmail.getNome() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TipoDeEmail_.NOME), tipoEmail.getNome()));
        }

        if (tipoEmail.getDescricao() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TipoDeEmail_.DESCRICAO), tipoEmail.getDescricao()));
        }

        if (tipoEmail.getTemplateHtml() != null) {
            if (tipoEmail.getTemplateHtml().getNome() != null) {
                predicate = builder.and(predicate,
                        builder.equal(from.get(TemplateHtml_.NOME), tipoEmail.getTemplateHtml().getNome()));
            }
        }

        if (tipoEmail.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TipoDeEmail_.INCLUDED_IN), new DateTime(tipoEmail.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (tipoEmail.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TipoDeEmail_.CHANGED_IN), new DateTime(tipoEmail.getChangedIn(), DateTimeZone.UTC)));
        }

        if (tipoEmail.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TipoDeEmail_.CHANGED_BY), tipoEmail.getIncludedBy()));
        }

        if (tipoEmail.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TipoDeEmail_.CHANGED_BY), tipoEmail.getChangedBy()));
        }

        final TypedQuery<TipoDeEmail> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(TipoDeEmail_.IDENTIFIER_TE)))
        );

        return (List<TipoDeEmail>) typedQuery.getResultList();
    }

    /**
     * Método para desativar ao inves de deletar a entidade
     *
     * @param entity
     */
    @Override
    public void delete(TipoDeEmail entity) {
        entity.desativarDomainEntity();
        super.delete(entity);
    }

}
