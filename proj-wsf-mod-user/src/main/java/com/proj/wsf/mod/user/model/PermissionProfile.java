/*
 * PermissionProfile.java
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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Description the class PermissionProfile - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 29/01/2019
 */
@Entity
@Table(name = "PERFIL_PERMISSAO")
@AttributeOverrides({
    @AttributeOverride(name = "active", column = @Column(name = "PP_ATIVO"))
    ,
    @AttributeOverride(name = "changedIn", column = @Column(name = "PP_ALTERADO_EM"))
    ,
    @AttributeOverride(name = "includedIn", column = @Column(name = "PP_INCLUIDO_EM"))
    ,
    @AttributeOverride(name = "changedBy", column = @Column(name = "PP_ALTERADO_POR"))
    ,
    @AttributeOverride(name = "includedBy", column = @Column(name = "PP_INCLUIDO_POR"))})
public class PermissionProfile extends DomainEntity {

    @EmbeddedId
    private PermissionProfileId id;

    @Expose(serialize = false, deserialize = false)
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Profile.class)
    @JoinColumn(name = "PE_ID", nullable = false, insertable = false, updatable = false)
    private Profile profile;
    
    
}
