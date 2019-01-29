/*
 * DomainEntity.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Description the class  DomainEntity - Classe de objeto real DomainEntity.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
@MappedSuperclass
public class DomainEntity implements IEntity, Serializable {

    private static final long serialVersionUID = -5377726703339445533L;

    @Expose
    @Column(name = "INCLUIDO_EM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date includedIn;

    @Expose
    @Column(name = "ALTERADO_EM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changedIn;

    @Expose
    @Column(name = "INCLUIDO_POR")
    private String includedBy;

    @Expose
    @Column(name = "ALTERADO_POR")
    private String changedBy;

    @Expose
    @Column(name = "ATIVO")
    private String active;


    /**
     * Método para retorno de data de inclusão.
     *
     * @return includedIn
     */
    public Date getIncludedIn() {
        return includedIn;
    }

    /**
     * Método para inserção de data de inclusão.
     *
     * @param includedIn
     */
    public void setIncludedIn(Date includedIn) {
        this.includedIn = includedIn;
    }

    /**
     * Método para retorno de active (S - sim ou N - não).
     *
     * @return active
     */
    public String getActive() {
        return active;
    }

    /**
     * Método para inserção de active (S - sim ou N - não).
     *
     * @param active
     */
    public void setActive(String active) {
        this.active = active;
    }

    /**
     * Método para retorno de data de alteração.
     *
     * @return changedIn
     */
    public Date getChangedIn() {
        return changedIn;
    }

    /**
     * Método para insercao de data de alteração.
     *
     * @param changedIn
     */
    public void setChangedIn(Date changedIn) {
        this.changedIn = changedIn;
    }

    /**
     * Método para retorno de data de inclusão.
     *
     * @return includedBy
     */
    public String getIncludedBy() {
        return includedBy;
    }

    /**
     * Método para inserção de autor da inclusão.
     *
     * @param includedBy
     */
    public void setIncludedBy(String includedBy) {
        this.includedBy = includedBy;
    }

    /**
     * Método para retorno de autor da alteração.
     *
     * @return changedBy
     */
    public String getChangedBy() {
        return changedBy;
    }

    /**
     * Método para inserção de autor da alteração.
     *
     * @param changedBy
     */
    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }
  
}
