/*
 * User.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.mod.user.model;

import com.google.gson.annotations.Expose;
import com.proj.wsf.model.DomainEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
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
    private Long identifier;

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
    @OneToMany(fetch = FetchType.LAZY, targetEntity = UserProfile.class,  cascade = CascadeType.ALL)
    @JoinColumn(name = "US_ID")
    private Collection<UserProfile> userProfiles;

    /**
     * Construtor padrão
     */
    public User() {
    }

    /**
     * Contrutor com parametros usuario e email.
     *
     * @param usuario - nome do usuario
     * @param email - email do usuario
     */
    public User(String usuario, String email) {
        this.usuario = usuario;
        this.email = email;
    }

    /**
     * Contrutor com parametros usuario e email.
     *
     * @param token - token do usuario
     */
    public User(String token) {
        this.token = token;
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
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     *
     * @return
     */
    public String getToken() {
        return token;
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
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param observacao
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    /**
     *
     * @param profile
     */
    public void addProfileCollectionUserProfile(Profile profile) {
        Collection<UserProfile> userProfs;

        if (this.userProfiles == null) {
            userProfs = new ArrayList<>();
        } else {
            userProfs = this.userProfiles;
        }

        UserProfile userProfile = new UserProfile();
        userProfile.setProfile(profile);
        userProfs.add(userProfile);
        this.userProfiles = userProfs;

    }

    /**
     *
     * @return
     */
    public Collection<UserProfile> getUserProfile() {

        if (this.userProfiles == null) {
            return null;
        }

        Collection<UserProfile> listaSegura = Collections.unmodifiableCollection(this.userProfiles);
        return listaSegura;
    }

    /**
     *
     * @return
     */
    public UserProfile getFirstUserProfile() {
        Collection<UserProfile> listaSegura = Collections.unmodifiableCollection(this.userProfiles);
        Optional<UserProfile> firstElement = listaSegura.stream().findFirst();
        return firstElement.get();
    }

    /**
     *
     * @param profile
     * @return
     */
    public UserProfile getSearchNameProfile(Profile profile) {
        Collection<UserProfile> listaSegura = Collections.unmodifiableCollection(this.userProfiles);
        UserProfile userProfile
                = listaSegura.stream()
                        .filter(x -> profile.getNome().equals(x.getProfile().getNome()))
                        .findAny()
                        .orElse(null);
        return userProfile;
    }

}
