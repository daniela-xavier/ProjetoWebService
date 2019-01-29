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
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Description the class  User - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 29/01/2019
 */
@Entity
@Table(name = "USUARIO")
@AttributeOverrides({
@AttributeOverride(name = "id", column = @Column(name = "US_ID")),
@AttributeOverride(name = "active", column = @Column(name = "US_ATIVO")),
@AttributeOverride(name = "changedIn", column = @Column(name = "US_ALTERADO_EM")),
@AttributeOverride(name = "includedIn", column = @Column(name = "US_INCLUIDO_EM")),
@AttributeOverride(name = "changedBy", column = @Column(name = "US_ALTERADO_POR")),
@AttributeOverride(name = "includedBy", column = @Column(name = "US_INCLUIDO_POR"))
})
public class User extends DomainEntity{
    
    @Id
    @Column(name = "US_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize=1)
    private Long id;
    
    @Expose
    @Column(name = "US_USUARIO", unique = true)
    private String usuario;

    @Expose
    @Column(name = "US_EMAIL", unique = true)
    private String email;

    @Expose
    @Column(name = "US_OBSERVACAO")
    private String observacao;

    @Expose
    @Column(name = "US_TOKEN")
    private String token;

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
    
    
}
