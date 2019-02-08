/*
 * UserProfileId.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.mod.user.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Description the class UserProfileId - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 29/01/2019
 */
@Embeddable
public class UserProfileId implements Serializable {

    static final long serialVersionUID = 42L;
    
    @Column(name = "PE_ID", nullable = false, insertable = false, updatable = false)
    private Long idProfile;

    @Column(name = "US_ID", nullable = false, insertable = false, updatable = false)
    private Long idUser;

    /**
     * default constructor
     */
    public UserProfileId() {
    }

    /**
     *
     * @param idProfile
     * @param idUser
     */
    public UserProfileId(final Long idProfile,final Long idUser) {
        this.idProfile = idProfile;
        this.idUser = idUser;
    }

    /**
     *
     * @return
     */
    public Long getIdProfile() {
        return idProfile;
    }

    /**
     *
     * @return
     */
    public Long getIdUser() {
        return idUser;
    }

    /**
     *
     * @param idProfile
     */
    public void setIdProfile(final Long idProfile) {
        this.idProfile = idProfile;
    }

    /**
     * 
     * @param idUser 
     */
    public void setIdUser(final Long idUser) {
        this.idUser = idUser;
    }

    /**
     * Método hashCode da classe
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return (int) (idProfile + idUser);
    }

    /**
     * Metodo equals da classe
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof UserProfileId) {
            final UserProfileId userProfileId = (UserProfileId) obj;
            return Objects.equals(userProfileId.idProfile, idProfile)
                    && Objects.equals(userProfileId.idUser, idUser);
        }
        return false;
    }

}
