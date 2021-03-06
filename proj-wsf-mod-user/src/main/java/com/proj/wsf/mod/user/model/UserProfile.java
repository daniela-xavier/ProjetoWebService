/*
 * UserProfile.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.mod.user.model;

import com.google.gson.annotations.Expose;
import com.proj.wsf.model.DomainEntity;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Description the class UserProfile - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 29/01/2019
 */
@Entity
@Table(name = "USUARIO_PERFIL")
@AttributeOverrides({
    @AttributeOverride(name = "active", column = @Column(name = "UP_ATIVO"))
    ,
    @AttributeOverride(name = "changedIn", column = @Column(name = "UP_ALTERADO_EM"))
    ,
    @AttributeOverride(name = "includedIn", column = @Column(name = "UP_INCLUIDO_EM"))
    ,
    @AttributeOverride(name = "changedBy", column = @Column(name = "UP_ALTERADO_POR"))
    ,
    @AttributeOverride(name = "includedBy", column = @Column(name = "UP_INCLUIDO_POR"))})
public class UserProfile extends DomainEntity {

    @EmbeddedId
    private UserProfileId identifier;

    @Expose
    @Column(name = "UP_DATA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;

    @Expose
    @Column(name = "UP_DATA_FIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    @Expose
    @Column(name = "TEMPORARIO")
    private String temporario;

    @Expose(serialize = false, deserialize = false)
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Profile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "PE_ID", nullable = false, insertable = false, updatable = false)
    private Profile profile;

    /**
     *
     * @return
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     *
     * @param profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    

}
