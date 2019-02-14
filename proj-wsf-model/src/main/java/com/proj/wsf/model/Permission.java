/*
 * Permission.java
 *
 * Created on 14-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.model;

/**
 * Description the class  Permission - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 14/02/2019
 */
public class Permission {

    private String nomePermission;
    private Boolean permissionGranted;

    public Permission() {
    }

    public Permission(String nomePermission, Boolean permissionGranted) {
        this.nomePermission = nomePermission;
        this.permissionGranted = permissionGranted;
    }

    public String getNomePermission() {
        return nomePermission;
    }

    public Boolean getPermissionGranted() {
        return permissionGranted;
    }
    
    
    
    
}
