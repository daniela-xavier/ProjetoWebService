/*
 * MicroService.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
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
 * Description the class  MicroService - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Entity
@Table(name = "MICROSERVICO")
@AttributeOverrides({
@AttributeOverride(name = "id", column = @Column(name = "MS_ID")),
@AttributeOverride(name = "active", column = @Column(name = "MS_ATIVO")),
@AttributeOverride(name = "changedIn", column = @Column(name = "MS_ALTERADO_EM")),
@AttributeOverride(name = "includedIn", column = @Column(name = "MS_INCLUIDO_EM")),
@AttributeOverride(name = "changedBy", column = @Column(name = "MS_ALTERADO_POR")),
@AttributeOverride(name = "includedBy", column = @Column(name = "MS_INCLUIDO_POR"))
})
public class MicroService extends DomainEntity{
  
    @Id
    @Column(name = "MS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MICROSERVICO")
    @SequenceGenerator(name = "SEQ_MICROSERVICO", sequenceName = "SEQ_MICROSERVICO", allocationSize=1)
    private Long identifier;
    
    @Expose
    @Column(name = "MS_NOME", unique = true)
    private String nome;

    @Expose
    @Column(name = "MS_DESCRICAO", unique = true)
    private String descricao;
    
    @Expose
    @Column(name = "MS_FLUXO_ARQUIVO", unique = true)
    private String fluxo;

    public Long getIdentifier() {
        return identifier;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFluxo() {
        return fluxo;
    }

    
    
}
