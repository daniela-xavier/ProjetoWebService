/*
 * TipoDeEmail.java
 *
 * Created on 18-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.model;

/**
 * Description the class  TipoDeEmail - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 18/02/2019
 */

import com.google.gson.annotations.Expose;
import com.proj.wsf.model.DomainEntity;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_EMAIL")
@AttributeOverrides({
@AttributeOverride(name = "active", column = @Column(name = "TE_ATIVO"))
    ,
@AttributeOverride(name = "changedIn", column = @Column(name = "TE_ALTERADO_EM"))
    ,
@AttributeOverride(name = "includedIn", column = @Column(name = "TE_INCLUIDO_EM"))
    ,
@AttributeOverride(name = "changedBy", column = @Column(name = "TE_ALTERADO_POR"))
    ,
@AttributeOverride(name = "includedBy", column = @Column(name = "TE_INCLUIDO_POR"))
})
public class TipoDeEmail extends DomainEntity {

    @Id
    @Column(name = "TE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_EMAIL")
    @SequenceGenerator(name = "SEQ_TIPO_EMAIL", sequenceName = "SEQ_TIPO_EMAIL", allocationSize = 1)
    private Long identifierTE;
    
    @Expose
    @Column(name = "TE_NOME", unique = true)
    private String nome;
    
    @Expose
    @Column(name = "TE_DESCRICAO", unique = true)
    private String descricao;
    
    @Expose
    @Column(name = "TE_SIGLA", unique = true)
    private String sigla;
    
    @Expose
    @Column(name = "TE_TITULO")
    private String titulo;
    
    @Expose
    @Column(name = "TE_ASSSUNTO")
    private String assunto;
    
    @Expose
    @Column(name = "TE_MENSAGEM")
    private String mensagem;
    
    @Expose
    @Column(name = "TE_MSG_SUCESSO")
    private String mensagemSucesso;
    
    @Expose
    @Column(name = "TE_MSG_FALHA")
    private String mensagemFalha;
    
    @Expose
    @Column(name = "TE_VALIDADE")
    private int validade;
       
    @Expose(serialize = false, deserialize = false)
    @OneToOne(fetch = FetchType.LAZY, targetEntity = TemplateHtml.class,  cascade = CascadeType.REFRESH)
    @JoinColumn(name = "TH_ID")
    private TemplateHtml templateHtml;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public TemplateHtml getTemplateHtml() {
        return templateHtml;
    }
                
    
    
}
