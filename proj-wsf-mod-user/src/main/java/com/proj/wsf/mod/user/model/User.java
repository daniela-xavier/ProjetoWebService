/*
 * User.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.mod.user.model;

import com.google.gson.annotations.Expose;
import com.proj.wsf.model.DomainEntity;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Description the class User - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 29/01/2019
 */
@Entity
@Table(name = "USUARIO")
@AttributeOverrides({
    @AttributeOverride(name = "active", column = @Column(name = "US_ATIVO"))
    ,
@AttributeOverride(name = "changedIn", column = @Column(name = "US_ALTERADO_EM"))
    ,
@AttributeOverride(name = "includedIn", column = @Column(name = "US_INCLUIDO_EM"))
    ,
@AttributeOverride(name = "changedBy", column = @Column(name = "US_ALTERADO_POR"))
    ,
@AttributeOverride(name = "includedBy", column = @Column(name = "US_INCLUIDO_POR"))
})
public class User extends DomainEntity {

    @Id
    @Column(name = "US_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    private Long id;

    @Expose
    @Column(name = "US_USUARIO", unique = true, nullable = false)
    private String usuario;

    @Expose
    @Column(name = "US_EMAIL", unique = true, nullable = false)
    private String email;

    @Expose
    @Column(name = "US_OBSERVACAO")
    private String observacao;

    @Expose
    @Column(name = "US_TOKEN", unique = true, nullable = false)
    private String token;

    @Expose(serialize = false, deserialize = false)
    @OneToMany(fetch = FetchType.LAZY, targetEntity = UserProfile.class)
    @JoinColumn(name = "US_ID")
    private Collection<UserProfile> userProfiles;

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getToken() {
        return token;
    }

    public Collection<UserProfile> getUserProfiles() {
        Collection<UserProfile> listaSegura = Collections.unmodifiableCollection(this.userProfiles);
        return listaSegura;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
