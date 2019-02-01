/*
 * UserProfileId.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
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

    @Column(name = "PE_ID",nullable=false, insertable=false, updatable=false)
    private Long idProfile;
    
    @Column(name = "US_ID",nullable=false, insertable=false, updatable=false)
    private Long idUser;

    // must have a default construcot
    public UserProfileId() {
    }

    public UserProfileId(Long idProfile, Long idUser) {
        this.idProfile = idProfile;
        this.idUser = idUser;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        return (int) (idProfile + idUser);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserProfileId) {
            UserProfileId userProfileId = (UserProfileId) obj;
            return Objects.equals(userProfileId.idProfile, idProfile)
                    && Objects.equals(userProfileId.idUser, idUser);
        }
        return false;
    }

}
