/*
 * QrCodeDAO.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.mod.email.model.QrCode;
import com.proj.wsf.mod.email.model.QrCode_;
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
 * Description the class  QrCodeDAO - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Repository("QrCodeDAO")
public class QrCodeDAO extends DAOImp<QrCode> implements IDAO<QrCode> {

    /**
     * Método que consulta todos os acões, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List QrCode
     */
    @Override
    public List<QrCode> findByMaxList(final int begin, final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<QrCode> query = builder.createQuery(QrCode.class);

        final TypedQuery<QrCode> typedQuery = this.em.createQuery(
                query.select(
                        query.from(QrCode.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        return (List<QrCode>) typedQuery.getResultList();

    }

    /**
     * Método que consulta tipoEmail de acordo com os atributos preenchidos.
     *
     * @param qrCode
     * @return List QrCode
     */
    @Override
    public List<QrCode> findByCriteria(final QrCode qrCode) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<QrCode> query = builder.createQuery(QrCode.class);
        final Root from = query.from(QrCode.class);

        Predicate predicate = builder.and();

        if (qrCode.getIdentifierQC() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(QrCode_.IDENTIFIER_QC), qrCode.getIdentifierQC()));
        }
        
        if (qrCode.getSequencia() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(QrCode_.SEQUENCIA), qrCode.getSequencia()));
        }

        if (qrCode.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(QrCode_.INCLUDED_IN), new DateTime(qrCode.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (qrCode.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(QrCode_.CHANGED_IN), new DateTime(qrCode.getChangedIn(), DateTimeZone.UTC)));
        }

        if (qrCode.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(QrCode_.CHANGED_BY), qrCode.getIncludedBy()));
        }

        if (qrCode.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(QrCode_.CHANGED_BY), qrCode.getChangedBy()));
        }

        final TypedQuery<QrCode> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(QrCode_.IDENTIFIER_QC)))
        );

        return (List<QrCode>) typedQuery.getResultList();
    }

    /**
     * Método para desativar ao inves de deletar a entidade
     *
     * @param entity
     */
    @Override
    public void delete(QrCode entity) {
        entity.desativarDomainEntity();
        super.delete(entity);
    }

}

