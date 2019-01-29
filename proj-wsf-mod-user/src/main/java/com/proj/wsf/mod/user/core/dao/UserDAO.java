/*
 * UserDAO.java
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
import com.proj.wsf.mod.user.model.User;
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
 * Description the class UserDAO - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 29/01/2019
 */
@Component("usuarioDAO")
@Repository
public class UserDAO extends DAOImp<User> implements IDAO<User> {

    /**
     * Método que consulta todos os usuários, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List<User>
     */
    @Override
    public List<User> findByMaxList(int begin, int end) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);

        TypedQuery<User> typedQuery = this.em.createQuery(
                query.select(
                        query.from(User.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        List<User> results = typedQuery.getResultList();
        return results;

    }

    /**
     * Método que consulta usuário de acordo com os atributos preenchidos.
     *
     * @param usuario
     * @return List<User>
     */
    @Override
    public List<User> findByCriteria(User usuario) {

        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root from = query.from(User.class);

        Predicate predicate = builder.and();

        if (usuario.getId() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Long>get("id"), usuario.getId()));
        }

        if (usuario.getEmail() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("email"), usuario.getEmail()));
        }

        if (usuario.getUsuario() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("usuario"), usuario.getUsuario()));
        }

        if (usuario.getEmail() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("email"), usuario.getEmail()));
        }

        if (usuario.getToken() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("token"), usuario.getToken()));
        }

        if (usuario.getObservacao() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("observacao"), usuario.getObservacao()));
        }
        
        if (usuario.getActive() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("active"), usuario.getActive()));
        }
        
        if (usuario.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("includedIn"), new DateTime(usuario.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (usuario.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("changedIn"), new DateTime(usuario.getChangedIn(), DateTimeZone.UTC)));
        }
        if (usuario.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("includedBy"), (usuario.getIncludedBy())));
        }

        if (usuario.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("chancedBy"), (usuario.getChangedBy())));
        }

        TypedQuery<User> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get("id")))
        );

        List<User> results = typedQuery.getResultList();
        return results;
    }

}
