/*
 * UserDAO.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.mod.user.core.dao;

import com.proj.wsf.core.IDAO;
import com.proj.wsf.core.dao.impl.DAOImp;
import com.proj.wsf.mod.user.model.Profile;
import com.proj.wsf.mod.user.model.Profile_;
import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.mod.user.model.UserProfile;
import com.proj.wsf.mod.user.model.UserProfile_;
import com.proj.wsf.mod.user.model.User_;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
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
@Component("userDAO")
@Repository
public class UserDAO extends DAOImp<User> implements IDAO<User> {

    /**
     * Método que consulta todos os usuários, porém retorna no numero inicial ao
     * numero final estabelecidos na consulta.
     *
     * @param begin
     * @param end
     * @return List User
     */
    @Override
    public List<User> findByMaxList(final int begin,final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<User> query = builder.createQuery(User.class);

        final TypedQuery<User> typedQuery = this.em.createQuery(
                query.select(
                        query.from(User.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        return (List<User>) typedQuery.getResultList();

    }

    /**
     * Método que consulta usuário de acordo com os atributos preenchidos.
     *
     * @param usuario
     * @return List User
     */
    @Override
    public List<User> findByCriteria(final User usuario) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<User> query = builder.createQuery(User.class);
        final Root from = query.from(User.class);

        Predicate predicate = builder.and();

        if (usuario.getIdentifier() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(User_.IDENTIFIER), usuario.getIdentifier()));
        }

        if (usuario.getEmail() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(User_.EMAIL), usuario.getEmail()));
        }

        if (usuario.getUsuario() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(User_.USUARIO), usuario.getUsuario()));
        }

        if (usuario.getToken() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(User_.TOKEN), usuario.getToken()));
        }

        if (usuario.getObservacao() != null) {
            if (usuario.getObservacao().contains("%")) {
                predicate = builder.and(predicate,
                        builder.like(from.get(User_.OBSERVACAO), "%" + usuario.getObservacao() + "%"));
            } else {
                predicate = builder.and(predicate,
                        builder.equal(from.get(User_.OBSERVACAO), usuario.getObservacao()));
            }
        }

        if (usuario.getActive() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(User_.ACTIVE), usuario.getActive()));
        }

        if (usuario.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(User_.INCLUDED_IN), new DateTime(usuario.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (usuario.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(User_.CHANGED_IN), new DateTime(usuario.getChangedIn(), DateTimeZone.UTC)));
        }
        if (usuario.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(User_.INCLUDED_BY), usuario.getIncludedBy()));
        }

        if (usuario.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(User_.CHANGED_BY), usuario.getChangedBy()));
        }

        if (usuario.getUserProfile() != null) {

            final Join<User, UserProfile> userProfiles = from.join(User_.USER_PROFILES);
            final Join<UserProfile, Profile> userProfProfile = userProfiles.join(UserProfile_.PROFILE);

            final Profile profile = usuario.getFirstUserProfile().getProfile();
            if (profile.getIdentifier() != null) {
                predicate = builder.and(predicate,
                        builder.equal(userProfProfile.get(Profile_.IDENTIFIER), profile.getIdentifier()));
            }
            if (profile.getNome() != null) {
                predicate = builder.and(predicate,
                        builder.equal(userProfProfile.get(Profile_.NOME), profile.getNome()));
            }
        }

        final TypedQuery<User> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(User_.IDENTIFIER)))
        );
      
        return (List<User>) typedQuery.getResultList();
    }

    /**
     * Método para desativar ao inves de deletar a entidade
     * @param entity 
     */
    @Override
    public void delete(User entity) {
        entity.desativarDomainEntity();
        super.delete(entity); 
    }

    
}
