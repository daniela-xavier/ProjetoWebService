/*
 * MainConfigurationDAO.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.main.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.main.model.MainConfiguration;
import com.proj.wsf.main.model.MainConfiguration_;
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
 * Description the class MainConfigurationDAO - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("mainConfigurationDAO")
@Repository
public class MainConfigurationDAO extends DAOImp<MainConfiguration> implements IDAO<MainConfiguration> {

    /**
     * Método que consulta todos os MainConfigurations, porém retorna no numero
     * inicial ao numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List MainConfiguration
     */
    @Override
    public List<MainConfiguration> findByMaxList(final int begin, final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<MainConfiguration> query = builder.createQuery(MainConfiguration.class);

        final TypedQuery<MainConfiguration> typedQuery = this.em.createQuery(
                query.select(
                        query.from(MainConfiguration.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit
     
        return (List<MainConfiguration>) typedQuery.getResultList();

    }

    /**
     * Método que consulta MainConfiguration de acordo com os atributos
     * preenchidos.
     *
     * @param mc
     * @return List MainConfiguration
     */
    @Override
    public List<MainConfiguration> findByCriteria(final MainConfiguration mc) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<MainConfiguration> query = builder.createQuery(MainConfiguration.class);
        final Root from = query.from(MainConfiguration.class);

        Predicate predicate = builder.and();

        if (mc.getIdentifier() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MainConfiguration_.IDENTIFIER), mc.getIdentifier()));
        }

        if (mc.getNome() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MainConfiguration_.NOME), mc.getNome()));
        }
        if (mc.getDescricao() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MainConfiguration_.DESCRICAO), mc.getDescricao()));
        }
        if (mc.getComando() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MainConfiguration_.COMANDO), mc.getComando()));
        }
        if (mc.getValor() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MainConfiguration_.VALOR), mc.getValor()));
        }
        
        if (mc.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MainConfiguration_.INCLUDED_IN), new DateTime(mc.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (mc.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MainConfiguration_.CHANGED_IN), new DateTime(mc.getChangedIn(), DateTimeZone.UTC)));
        }

        if (mc.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MainConfiguration_.INCLUDED_BY), mc.getIncludedBy()));
        }

        if (mc.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(MainConfiguration_.CHANGED_BY), mc.getChangedBy()));
        }

        final TypedQuery<MainConfiguration> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(MainConfiguration_.IDENTIFIER)))
        );

       return (List<MainConfiguration>) typedQuery.getResultList();
    }
     /**
     * Método para desativar ao inves de deletar a entidade
     * @param entity 
     */
    @Override
    public void delete(MainConfiguration entity) {
        entity.desativarDomainEntity();
        super.delete(entity); 
    }

}
