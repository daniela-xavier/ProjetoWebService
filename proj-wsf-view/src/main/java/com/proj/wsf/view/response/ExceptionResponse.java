/*
 * ExceptionResponse.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.view.response;

import org.springframework.http.HttpStatus;

/**
 * Description the class ExceptionResponse - Classe responsável pelo retorno de
 * exceções da aplicação.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 23/01/2019
 */
public class ExceptionResponse extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    /**
     * Construtor da classe com parametro.
     *
     * @param message - retorna message
     * @param httpStatus - retorna http status
     */
    public ExceptionResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    /**
     * Metodo de recuperacao de mensagem.
     *
     * @return String
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * Metodo de recuperacao de Http Status.
     *
     * @return HttpStatus
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
