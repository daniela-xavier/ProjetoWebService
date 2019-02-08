/*
 * PermissionProfileId.java
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
 * Description the class PermissionProfileId - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 29/01/2019
 */
@Embeddable
public class PermissionProfileId implements Serializable {

    @Column(name = "PE_ID", nullable = false, insertable = false, updatable = false)
    private Long idProfile;

    @Column(name = "MS_AC_ID", nullable = false, insertable = false, updatable = false)
    private Long idActMicroService;

    

    /**
     * default construcot
     */
    public PermissionProfileId() {
    }

    /**
     *
     * @param idProfile
     * @param idActMicroService
     */
    public PermissionProfileId(Long idProfile, Long idActMicroService) {
        this.idProfile = idProfile;
        this.idActMicroService = idActMicroService;
    }
     
    /**
     * 
     * @return int
     */
    @Override
    public int hashCode() {
        return (int) (idProfile + idActMicroService);
    }

    /**
     * 
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PermissionProfileId) {
            PermissionProfileId permissionProfileId = (PermissionProfileId) obj;
            return Objects.equals(permissionProfileId.idProfile, idProfile)
                    && Objects.equals(permissionProfileId.idActMicroService, idActMicroService);
        }
        return false;
    }

}
