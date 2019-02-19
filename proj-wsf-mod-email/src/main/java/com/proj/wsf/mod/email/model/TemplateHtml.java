/*
 * TemplateHtml.java
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
 * Description the class  TemplateHtml - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 18/02/2019
 */
@Entity
@Table(name = "TEMPLATE_HTML")
@AttributeOverrides({
@AttributeOverride(name = "active", column = @Column(name = "TH_ATIVO"))
    ,
@AttributeOverride(name = "changedIn", column = @Column(name = "TH_ALTERADO_EM"))
    ,
@AttributeOverride(name = "includedIn", column = @Column(name = "TH_INCLUIDO_EM"))
    ,
@AttributeOverride(name = "changedBy", column = @Column(name = "TH_ALTERADO_POR"))
    ,
@AttributeOverride(name = "includedBy", column = @Column(name = "TH_INCLUIDO_POR"))
})
public class TemplateHtml extends DomainEntity {

    @Id
    @Column(name = "TH_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TEMPLATE_HTML")
    @SequenceGenerator(name = "SEQ_TEMPLATE_HTML", sequenceName = "SEQ_TEMPLATE_HTML", allocationSize = 1)
    private Long identifierTH;
    
    @Expose
    @Column(name = "TH_NOME", unique = true)
    private String nome;
    
    @Expose
    @Column(name = "TH_DESCRICAO", unique = true)
    private String descricao;
    
    @Expose
    @Column(name = "TH_HEADER")
    private String header;
    
    @Expose
    @Column(name = "TH_SESSION")
    private String session;
    
    @Expose
    @Column(name = "TH_FOOTER")
    private String footer;
    
    @Expose
    @Column(name = "TH_ARTICLE")
    private String article;
    
    @Expose
    @Column(name = "TH_NAV")
    private String nav;
    
    @Expose
    @Column(name = "TH_ASIDE")
    private String aside;

    public String getNome() {
        return nome;
    }
    
    





}
