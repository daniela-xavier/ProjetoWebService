/*
 * Profile.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
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
 * Description the class Profile - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 29/01/2019
 */
@Entity
@Table(name = "PERFIL")
@AttributeOverrides({
    @AttributeOverride(name = "active", column = @Column(name = "PE_ATIVO"))
    ,
    @AttributeOverride(name = "changedIn", column = @Column(name = "PE_ALTERADO_EM"))
    ,
    @AttributeOverride(name = "includedIn", column = @Column(name = "PE_INCLUIDO_EM"))
    ,
    @AttributeOverride(name = "changedBy", column = @Column(name = "PE_ALTERADO_POR"))
    ,
    @AttributeOverride(name = "includedBy", column = @Column(name = "PE_INCLUIDO_POR"))})
public class Profile extends DomainEntity {

    @Id
    @Column(name = "PE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERFIL")
    @SequenceGenerator(name = "SEQ_PERFIL", sequenceName = "SEQ_PERFIL", allocationSize = 1)
    private Long identifier;

    @Expose
    @Column(name = "PE_NOME", unique = true)
    private String nome;

    @Expose
    @Column(name = "PE_DESCRICAO")
    private String descricao;

    /**
     *
     */
    public Profile() {
    }
    
    /**
     *
     * @param nome
     */
    public Profile(String nome) {
       this.nome = nome;    
    }
 
    /**
     *
     * @return
     */
    public Long getIdentifier() {
        return identifier;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param identifier
     */
    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /*
    public Collection<PermissionProfile> getPermissionProfile() {
    Collection<PermissionProfile> listaSegura = Collections.unmodifiableCollection(this.permissions);
    return listaSegura;
    }
    
    public PermissionProfile getFirstPermissionProfile() {
    Collection<PermissionProfile> listaSegura = Collections.unmodifiableCollection(this.permissions);
    Optional<PermissionProfile> firstElement = listaSegura.stream().findFirst();
    return firstElement.get();
    }*/
}
