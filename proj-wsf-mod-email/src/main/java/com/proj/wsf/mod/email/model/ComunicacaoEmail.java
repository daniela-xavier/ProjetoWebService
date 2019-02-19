/*
 * ComunicacaoEmail.java
 *
 * Created on 18-02-2019
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Description the class ComunicacaoEmail - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 18/02/2019
 */
@Entity
@Table(name = "COMUNICACAO_EMAIL")
@AttributeOverrides({
    @AttributeOverride(name = "active", column = @Column(name = "CME_ATIVO"))
    ,
@AttributeOverride(name = "changedIn", column = @Column(name = "CME_ALTERADO_EM"))
    ,
@AttributeOverride(name = "includedIn", column = @Column(name = "CME_INCLUIDO_EM"))
    ,
@AttributeOverride(name = "changedBy", column = @Column(name = "CME_ALTERADO_POR"))
    ,
@AttributeOverride(name = "includedBy", column = @Column(name = "CME_INCLUIDO_POR"))
})
public class ComunicacaoEmail extends DomainEntity {

    @Id
    @Column(name = "CME_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMUNICACAO_EMAIL")
    @SequenceGenerator(name = "SEQ_COMUNICACAO_EMAIL", sequenceName = "SEQ_COMUNICACAO_EMAIL", allocationSize = 1)
    private Long identifierCME;

    @Expose
    @Column(name = "CME_ASSUNTO")
    private String assunto;

    @Expose
    @Column(name = "CME_TITULO")
    private String titulo;

    @Expose
    @Column(name = "CME_CAMINHO_PDF")
    private String caminhoPdf;

    @Expose
    @Column(name = "CME_MENSAGEM")
    private String mensagem;

    @Expose
    @Column(name = "TE_ID")
    private int tipoEmail;

    @Expose
    @Column(name = "CE_ID")
    private int remetente;

    @Expose
    @Column(name = "QC_ID")
    private String qrCode;

    @Expose
    @Column(name = "PS_ID")
    private int pessoa;

    public Long getIdentifierCME() {
        return identifierCME;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCaminhoPdf() {
        return caminhoPdf;
    }

    public String getQrCode() {
        return qrCode;
    }


    
    
}
