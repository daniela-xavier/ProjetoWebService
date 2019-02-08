/*
 * MainConfiguration.java
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
 * Description the class  MainConfiguration - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Entity
@Table(name = "CONFIG_WEB_SERVICE_FOZ")
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONFIG_WEB_SERVICE_FOZ")
    @SequenceGenerator(name = "SEQ_CONFIG_WEB_SERVICE_FOZ", sequenceName = "SEQ_CONFIG_WEB_SERVICE_FOZ", allocationSize=1)
    private Long identifier;
    
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

    /**
     * Retornar Id
     * @return long
     */
    public Long getIdentifier() {
        return identifier;
    }

    /**
     * Retorna nome
     * @return string
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna descricao
     * @return string
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna comando
     * @return string
     */
    public String getComando() {
        return comando;
    }

    /**
     * Retorna valor
     * @return string
     */
    public String getValor() {
        return valor;
    }
   
    
    

}

