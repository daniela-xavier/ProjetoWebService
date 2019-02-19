/*
 * TemplateHtmlDAO.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.mod.email.model.TemplateHtml;
import com.proj.wsf.mod.email.model.TemplateHtml_;
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
 * Description the class  TemplateHtmlDAO - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Repository("templateHtmlDAO")
public class TemplateHtmlDAO extends DAOImp<TemplateHtml> implements IDAO<TemplateHtml> {

    /**
     * Método que consulta todos os acões, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List TemplateHtml
     */
    @Override
    public List<TemplateHtml> findByMaxList(final int begin, final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<TemplateHtml> query = builder.createQuery(TemplateHtml.class);

        final TypedQuery<TemplateHtml> typedQuery = this.em.createQuery(
                query.select(
                        query.from(TemplateHtml.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        return (List<TemplateHtml>) typedQuery.getResultList();

    }

    /**
     * Método que consulta tipoEmail de acordo com os atributos preenchidos.
     *
     * @param templateHtml
     * @return List TemplateHtml
     */
    @Override
    public List<TemplateHtml> findByCriteria(final TemplateHtml templateHtml) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<TemplateHtml> query = builder.createQuery(TemplateHtml.class);
        final Root from = query.from(TemplateHtml.class);

        Predicate predicate = builder.and();

        if (templateHtml.getNome() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TemplateHtml_.NOME), templateHtml.getNome()));
        }

        if (templateHtml.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TemplateHtml_.INCLUDED_IN), new DateTime(templateHtml.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (templateHtml.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TemplateHtml_.CHANGED_IN), new DateTime(templateHtml.getChangedIn(), DateTimeZone.UTC)));
        }

        if (templateHtml.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TemplateHtml_.CHANGED_BY), templateHtml.getIncludedBy()));
        }

        if (templateHtml.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(TemplateHtml_.CHANGED_BY), templateHtml.getChangedBy()));
        }

        final TypedQuery<TemplateHtml> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(TemplateHtml_.IDENTIFIER_TH)))
        );

        return (List<TemplateHtml>) typedQuery.getResultList();
    }

    /**
     * Método para desativar ao inves de deletar a entidade
     *
     * @param entity
     */
    @Override
    public void delete(TemplateHtml entity) {
        entity.desativarDomainEntity();
        super.delete(entity);
    }

}
