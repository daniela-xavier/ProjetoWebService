/*
 * RetornoFalhaEmail.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */
package com.proj.wsf.mod.email.model;

/**
 * Description the class RetornoFalhaEmail - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 19/02/2019
 */
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

@Entity
@Table(name = "ERRO_EMAIL_RESP")
@AttributeOverrides({
    @AttributeOverride(name = "active", column = @Column(name = "EER_ATIVO"))
    ,
@AttributeOverride(name = "changedIn", column = @Column(name = "EER_ALTERADO_EM"))
    ,
@AttributeOverride(name = "includedIn", column = @Column(name = "EER_INCLUIDO_EM"))
    ,
@AttributeOverride(name = "changedBy", column = @Column(name = "EER_ALTERADO_POR"))
    ,
@AttributeOverride(name = "includedBy", column = @Column(name = "EER_INCLUIDO_POR"))
})
public class RetornoFalhaEmail extends DomainEntity {

    @Id
    @Column(name = "EER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ERRO_EMAIL_RESP")
    @SequenceGenerator(name = "SEQ_ERRO_EMAIL_RESP", sequenceName = "SEQ_ERRO_EMAIL_RESP", allocationSize = 1)
    private Long identifierEER;
    
    @Expose
    @Column(name = "EER_CODIGO", unique = true)
    private String codigo;
    
    @Expose
    @Column(name = "EER_MENSAGEM", unique = true)
    private String mensagem;

    public String getCodigo() {
        return codigo;
    }

    
     
}
