/*
 * ContaEmail.java
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
 * Description the class ContaEmail - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 18/02/2019
 */
@Entity
@Table(name = "CONTA_EMAIL")
@AttributeOverrides({
@AttributeOverride(name = "active", column = @Column(name = "CE_ATIVO"))
    ,
@AttributeOverride(name = "changedIn", column = @Column(name = "CE_ALTERADO_EM"))
    ,
@AttributeOverride(name = "includedIn", column = @Column(name = "CE_INCLUIDO_EM"))
    ,
@AttributeOverride(name = "changedBy", column = @Column(name = "CE_ALTERADO_POR"))
    ,
@AttributeOverride(name = "includedBy", column = @Column(name = "CE_INCLUIDO_POR"))
})
public class ContaEmail extends DomainEntity {

    @Id
    @Column(name = "CE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTA_EMAIL")
    @SequenceGenerator(name = "SEQ_CONTA_EMAIL", sequenceName = "SEQ_CONTA_EMAIL", allocationSize = 1)
    private Long identifierCE;

    @Expose
    @Column(name = "CE_USUARIO", unique = true)
    private String usuario;
    
    @Expose
    @Column(name = "CE_SENHA", unique = true)
    private String senha;
    
    @Expose
    @Column(name = "CE_HOST_SMTP")
    private String hostSmtp;
    
    @Expose
    @Column(name = "CE_PORTA_SMTP")
    private String portaSmtp;
    
    @Expose
    @Column(name = "CE_HOST_IMAP")
    private String hostImap;
    
    @Expose
    @Column(name = "CE_PORTA_IMAP")
    private String portaImap;
    
    @Expose
    @Column(name = "CE_HOST_POP")
    private String hostPop;
    
    @Expose
    @Column(name = "CE_PORTA_POP")
    private String portaPop;
    
    @Expose
    @Column(name = "CE_CHARSET")
    private String charset;
        
    @Expose
    @Column(name = "CE_PROTOCOLO")
    private String protocolo;
      
    @Expose
    @Column(name = "CE_TIPO_CONEXAO")
    private String tipoConexao;
    
    @Expose
    @Column(name = "CE_SMTP_TLS_ATIVO")
    private Boolean smtpTlsAtivo;
    
    @Expose
    @Column(name = "CE_SMTP_SSL_ATIVO")
    private Boolean smtpSslAtivo;
    
    @Expose
    @Column(name = "CE_IMAP_AUTH_ATIVO")
    private String imapAuthAtivo;
    
    @Expose
    @Column(name = "CE_PASTA")
    private String pasta;
    
    @Expose
    @Column(name = "CE_DEBUG")
    private Boolean debugAtivo;
    
    @Expose
    @Column(name = "CE_TIPO_DEBUG")
    private String tipoDebug;

    public Long getIdentifierCE() {
        return identifierCE;
    }

    public String getUsuario() {
        return usuario;
    }
       
    
}
