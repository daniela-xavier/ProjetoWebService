/*
 * Result.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.core.application;

import com.proj.wsf.model.DomainEntity;

/**
 * Description the class  Result - Classe que comporta o resultado dos serviços
 * e operações.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public class Result {

    private String msg;
    private Iterable<DomainEntity> entity;
    private boolean error;

    /**
     * Método de recuperação do campo msg
     *
     * @return valor do campo msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Valor de msg atribuído a msg
     *
     * @param msg Atributo da Classe
     */
    public void setMsg(String msg) {
        this.msg = msg;
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


