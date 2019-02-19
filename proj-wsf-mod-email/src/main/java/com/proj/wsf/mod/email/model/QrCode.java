/*
 * QrCode.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.model;

import com.google.gson.annotations.Expose;
import com.proj.wsf.model.DomainEntity;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description the class  QrCode - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Entity
@Table(name = "ERRO_EMAIL_RESP")
@AttributeOverrides({
    @AttributeOverride(name = "active", column = @Column(name = "QC_ATIVO"))
    ,
@AttributeOverride(name = "changedIn", column = @Column(name = "QC_ALTERADO_EM"))
    ,
@AttributeOverride(name = "includedIn", column = @Column(name = "QC_INCLUIDO_EM"))
    ,
@AttributeOverride(name = "changedBy", column = @Column(name = "QC_ALTERADO_POR"))
    ,
@AttributeOverride(name = "includedBy", column = @Column(name = "QC_INCLUIDO_POR"))
})
public class QrCode extends DomainEntity {

    @Id
    @Column(name = "QC_ID")
    private String identifierQC;
    
    @Expose
    @Column(name = "QC_STRING", unique = true)
    private String sequencia;
    
    @Expose
    @Column(name = "QC_VALIDADE")
    private int validade;
        
    @Expose
    @Column(name = "PS_ID")
    private String pessoa;

    public String getIdentifierQC() {
        return identifierQC;
    }

    public String getSequencia() {
        return sequencia;
    }


}
