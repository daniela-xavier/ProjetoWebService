/*
 * ProfileDAO.java
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
 * Description the class ProfileDAO - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 29/01/2019
 */
@Component("profileDAO")
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
    public List<Profile> findByMaxList(final int begin,final int end) {
        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<Profile> query = builder.createQuery(Profile.class);

        final TypedQuery<Profile> typedQuery = this.em.createQuery(
                query.select(
                        query.from(Profile.class))
        ).setFirstResult(begin) // offset
                .setMaxResults(end); // limit

        return (List<Profile>) typedQuery.getResultList();

    }

    /**
     * Método que consulta usuário de acordo com os atributos preenchidos.
     *
     * @param perfil
     * @return List<Profile>
     */
    @Override
    public List<Profile> findByCriteria(final Profile perfil) {

        final CriteriaBuilder builder = this.em.getCriteriaBuilder();
        final CriteriaQuery<Profile> query = builder.createQuery(Profile.class);
        Root from = query.from(Profile.class);

        Predicate predicate = builder.and();

        if (perfil.getIdentifier() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Profile_.IDENTIFIER), perfil.getIdentifier()));
        }

        if (perfil.getNome() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Profile_.NOME), perfil.getNome()));
        }

        if (perfil.getDescricao() != null) {

            if (perfil.getDescricao().contains("%")) {
                predicate = builder.and(predicate,
                        builder.like(from.get(Profile_.DESCRICAO), "%" + perfil.getDescricao() + "%"));
            } else {
                predicate = builder.and(predicate,
                        builder.equal(from.get(Profile_.DESCRICAO), perfil.getDescricao()));
            }
        }

        if (perfil.getActive() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Profile_.ACTIVE), perfil.getActive()));
        }

        if (perfil.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Profile_.INCLUDED_IN), new DateTime(perfil.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (perfil.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Profile_.CHANGED_IN), new DateTime(perfil.getChangedIn(), DateTimeZone.UTC)));
        }
        if (perfil.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Profile_.INCLUDED_BY), perfil.getIncludedBy()));
        }

        if (perfil.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.get(Profile_.CHANGED_BY), perfil.getChangedBy()));
        }

        final TypedQuery<Profile> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get(Profile_.IDENTIFIER)))
        );
        
        return (List<Profile>) typedQuery.getResultList();
    }

    @Override
    public void delete(Profile entity) {
        entity.setActive("n");
        super.delete(entity);
    }

}
