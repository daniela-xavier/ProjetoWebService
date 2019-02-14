/*
 * Result.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core.application;

import com.google.gson.annotations.Expose;
import com.proj.wsf.model.DomainEntity;

/**
 * Description the class  Result - Classe que comporta o resultado dos serviços
 * e operações.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public class Result {

    @Expose
    private String message;
    
    @Expose
    private Iterable<DomainEntity> entity;
    
    @Expose
    private boolean error;

    /**
     * Método de recuperação do campo message
     *
     * @return valor do campo message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Valor de message atribuído a message
     *
     * @param message Atributo da Classe
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Método de recuperação do campo entity
     *
     * @return valor do campo entity
     */
    public Iterable<DomainEntity> getEntity() {
        return entity;
    }

    /**
     * Valor de entity atribuído a entity
     *
     * @param entity Atributo da Classe
     */
    public void setEntity(Iterable<DomainEntity> entity) {
        this.entity = entity;
    }

    /**
     * Método de recuperação do campo error.
     *
     * @return error (true - contém erro ou false - não contém erro.)
     */
    public boolean hasError() {
        return this.error;
    }

    /**
     * Método que atribui true (contém erro) a variável error.
     */
    public void setError() {
        this.error = true;
    }
}


