/*
 * ProfileDAO.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.mod.user.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.mod.user.model.Profile;
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
 * Description the class  ProfileDAO - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 29/01/2019
 */
@Component("perfilDAO")
@Repository
public class ProfileDAO extends DAOImp<Profile> implements IDAO<Profile> {

    /**
     * Método que consulta todos os usuários, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List<Profile>
     */
    @Override
    public List<Profile> findByMaxList(int begin, int end) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Profile> query = builder.createQuery(Profile.class);

        TypedQuery<Profile> typedQuery = this.em.createQuery(
                query.select(
                        query.from(Profile.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        List<Profile> results = typedQuery.getResultList();
        return results;

    }

    /**
     * Método que consulta usuário de acordo com os atributos preenchidos.
     *
     * @param perfil
     * @return List<Profile>
     */
    @Override
    public List<Profile> findByCriteria(Profile perfil) {

        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Profile> query = builder.createQuery(Profile.class);
        Root from = query.from(Profile.class);

        Predicate predicate = builder.and();

        if (perfil.getId() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Long>get("id"), perfil.getId()));
        }

        if (perfil.getNome() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("nome"), perfil.getNome()));
        }

        if (perfil.getDescricao()!= null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("descricao"), perfil.getDescricao()));
        }
        
        if (perfil.getActive() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("active"), perfil.getActive()));
        }
        
        if (perfil.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("includedIn"), new DateTime(perfil.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (perfil.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("changedIn"), new DateTime(perfil.getChangedIn(), DateTimeZone.UTC)));
        }
        if (perfil.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("includedBy"), (perfil.getIncludedBy())));
        }

        if (perfil.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("chancedBy"), (perfil.getChangedBy())));
        }

        TypedQuery<Profile> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get("id")))
        );

        List<Profile> results = typedQuery.getResultList();
        return results;
    }

}

