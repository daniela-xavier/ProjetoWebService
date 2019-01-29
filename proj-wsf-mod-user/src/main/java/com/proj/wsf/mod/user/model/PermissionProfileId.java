/*
 * PermissionProfileId.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.mod.user.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Description the class PermissionProfileId - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 29/01/2019
 */

@Embeddable
public class PermissionProfileId implements Serializable {

    private Long idProfile;
    private Long idActMicroService;

    // must have a default construcot
    public PermissionProfileId() {
    }

    public PermissionProfileId(Long idProfile, Long idActMicroService) {
        this.idProfile = idProfile;
        this.idActMicroService = idActMicroService;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public Long getIdActMicroService() {
        return idActMicroService;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public void setIdActMicroService(Long idActMicroService) {
        this.idActMicroService = idActMicroService;
    }

}
