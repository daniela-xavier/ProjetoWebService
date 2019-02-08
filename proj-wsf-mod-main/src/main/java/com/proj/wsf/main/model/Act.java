/*
 * Act.java
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
 * Description the class  Act - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Entity
@Table(name = "ACAO")
@AttributeOverrides({
@AttributeOverride(name = "id", column = @Column(name = "AC_ID")),
@AttributeOverride(name = "active", column = @Column(name = "AC_ATIVO")),
@AttributeOverride(name = "changedIn", column = @Column(name = "AC_ALTERADO_EM")),
@AttributeOverride(name = "includedIn", column = @Column(name = "AC_INCLUIDO_EM")),
@AttributeOverride(name = "changedBy", column = @Column(name = "AC_ALTERADO_POR")),
@AttributeOverride(name = "includedBy", column = @Column(name = "AC_INCLUIDO_POR"))
})
public class Act extends DomainEntity{
  
    @Id
    @Column(name = "AC_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACAO")
    @SequenceGenerator(name = "SEQ_ACAO", sequenceName = "SEQ_ACAO", allocationSize=1)
    private Long identifier;
    
    @Expose
    @Column(name = "AC_NOME", unique = true)
    private String nome;

    @Expose
    @Column(name = "AC_DESCRICAO", unique = true)
    private String descricao;

    /**
     *
     * @return
     */
    public Long getIdentifier() {
        return identifier;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    
    
    
}
