/*
 * MainConfiguration.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.main.model;

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
 * Description the class  MainConfiguration - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Entity
@Table(name = "CONFIGWEBSERVICEFOZ")
@AttributeOverrides({
@AttributeOverride(name = "id", column = @Column(name = "CWSF_ID")),
@AttributeOverride(name = "active", column = @Column(name = "CWSF_ATIVO")),
@AttributeOverride(name = "changedIn", column = @Column(name = "CWSF_ALTERADO_EM")),
@AttributeOverride(name = "includedIn", column = @Column(name = "CWSF_INCLUIDO_EM")),
@AttributeOverride(name = "changedBy", column = @Column(name = "CWSF_ALTERADO_POR")),
@AttributeOverride(name = "includedBy", column = @Column(name = "CWSF_INCLUIDO_POR"))
})
public class MainConfiguration extends DomainEntity{
  
    @Id
    @Column(name = "CWSF_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONFIGWEBSERVICEFOZ")
    @SequenceGenerator(name = "SEQ_CONFIGWEBSERVICEFOZ", sequenceName = "SEQ_CONFIGWEBSERVICEFOZ", allocationSize=1)
    private Long id;
    
    @Expose
    @Column(name = "CWSF_NOME", unique = true)
    private String nome;

    @Expose
    @Column(name = "CWSF_DESCRICAO", unique = true)
    private String descricao;
    
    @Expose
    @Column(name = "CWSF_COMANDO", unique = true)
    private String comando;
    
    @Expose
    @Column(name = "CWSF_VALOR", unique = true)
    private String valor;
   

}

