package com.proj.wsf.view.response;

/*
 * ResponseMessage.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */


import com.proj.wsf.core.application.EntityApplication;

/**
 * Description the class  ResponseMessage - Classe responsável pela mensagem de
 * resposta da aplicação.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public class ResponseMessage extends EntityApplication {

    private final Boolean hasError;
    private final String message;

    /**
     * Construtor com parametros.
     * @param hasError - Se há erro ou não na resposta.
     * @param message - Se há mensagem de erro ou não.
     */
    public ResponseMessage(Boolean hasError, String message) {
        this.hasError = hasError;
        this.message = message;
    }

    /**
     * Método que retorna o estado de erro.
     * @return Boolean - (true - com erro, false - sem erro).
     */
    public Boolean getHasError() {
        return hasError;
    }

    /**
     * Método de recuperação da mensagem.
     * @return String
     */
    public String getMessage() {
        return message;
    }
}

