/*
 * ComunicacaoEmailDAO.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.mod.email.model.ComunicacaoEmail;
import com.proj.wsf.mod.email.model.ComunicacaoEmail_;
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
 * Description the class  ComunicacaoEmailDAO - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Repository("ComunicacaoEmailDAO")
public class ComunicacaoEmailDAO extends DAOImp<ComunicacaoEmail> implements IDAO<ComunicacaoEmail> {

    /**
     * Método que consulta todos os acões, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List ComunicacaoEmail
     */
    @Override
    public List<ComunicacaoEmail> findByMaxList(final int begin, final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<ComunicacaoEmail> query = builder.createQuery(ComunicacaoEmail.class);

        final TypedQuery<ComunicacaoEmail> typedQuery = this.em.createQuery(
                query.select(
                        query.from(ComunicacaoEmail.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        return (List<ComunicacaoEmail>) typedQuery.getResultList();

    }

    /**
     * Método que consulta tipoEmail de acordo com os atributos preenchidos.
     *
     * @param comunicacaoEmail
     * @return List ComunicacaoEmail
     */
    @Override
    public List<ComunicacaoEmail> findByCriteria(final ComunicacaoEmail comunicacaoEmail) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<ComunicacaoEmail> query = builder.createQuery(ComunicacaoEmail.class);
        final Root from = query.from(ComunicacaoEmail.class);

        Predicate predicate = builder.and();

        if (comunicacaoEmail.getIdentifierCME() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ComunicacaoEmail_.IDENTIFIER_CM_E), comunicacaoEmail.getIdentifierCME()));
        }

        if (comunicacaoEmail.getQrCode()!= null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ComunicacaoEmail_.QR_CODE), comunicacaoEmail.getQrCode()));
        }
        
        if (comunicacaoEmail.getAssunto()!= null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ComunicacaoEmail_.ASSUNTO), comunicacaoEmail.getAssunto()));
        }
        
        if (comunicacaoEmail.getTitulo()!= null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ComunicacaoEmail_.TITULO), comunicacaoEmail.getTitulo()));
        }
        
        if (comunicacaoEmail.getCaminhoPdf()!= null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ComunicacaoEmail_.CAMINHO_PDF), comunicacaoEmail.getCaminhoPdf()));
        }
        
        if (comunicacaoEmail.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ComunicacaoEmail_.INCLUDED_IN), new DateTime(comunicacaoEmail.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (comunicacaoEmail.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ComunicacaoEmail_.CHANGED_IN), new DateTime(comunicacaoEmail.getChangedIn(), DateTimeZone.UTC)));
        }

        if (comunicacaoEmail.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ComunicacaoEmail_.CHANGED_BY), comunicacaoEmail.getIncludedBy()));
        }

        if (comunicacaoEmail.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(ComunicacaoEmail_.CHANGED_BY), comunicacaoEmail.getChangedBy()));
        }

        final TypedQuery<ComunicacaoEmail> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(ComunicacaoEmail_.IDENTIFIER_CM_E)))
        );

        return (List<ComunicacaoEmail>) typedQuery.getResultList();
    }

    /**
     * Método para desativar ao inves de deletar a entidade
     *
     * @param entity
     */
    @Override
    public void delete(ComunicacaoEmail entity) {
        entity.desativarDomainEntity();
        super.delete(entity);
    }

}

