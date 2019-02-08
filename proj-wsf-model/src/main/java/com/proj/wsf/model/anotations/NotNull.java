/*
 * NotNull.java
 *
 * Created on 08-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.model.anotations;

import com.proj.wsf.model.anotations.validator.NotNullValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

/**
 * Description the class NotNull - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 08/02/2019
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullValidator.class)
public @interface NotNull {

    /**
     * Método da anotação para mensagem.
     *
     * @return String
     */
    String message() default "Valor inválido";

    /**
     * Método da anotação para valor.
     *
     * @return String
     */
    public String value() default "";

    /**
     * Método da anotação para executar validacao na ação salvar.
     *
     * @return String
     */
    public boolean save();

    /**
     * Método da anotação para executar validacao na ação alterar.
     *
     * @return String
     */
    public boolean update();

    /**
     * Método da anotação para executar validacao na ação consulta todos.
     *
     * @return String
     */
    public boolean findAll();

    /**
     * Método da anotação para executar validacao na ação consultar por filtro.
     *
     * @return String
     */
    public boolean findFilter();

    /**
     * Método da anotação para executar validacao na ação consultar por id.
     *
     * @return String
     */
    public boolean findById();

    /**
     * Método da anotação para executar validacao na ação deletar.
     *
     * @return String
     */
    public boolean delete();

    /**
     * Método da anotação para executar validacao na ação desabilitar.
     *
     * @return String
     */
    public boolean disable();

}
