/*
 * DateNotNullValidator.java
 *
 * Created on 12-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */
package com.proj.wsf.model.anotations.validator;

import com.proj.wsf.model.anotations.ActivePattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Description the class DateNotNullValidator - Validador de date nula.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 12/02/2019
 */
public class ActivePatternValidator implements ConstraintValidator<ActivePattern, String> {

    @Override
    public void initialize(ActivePattern constraintAnnotation) {

    }

    @Override
    public boolean isValid(String active, ConstraintValidatorContext context) {
        return active.equals("s") || active.equals("n");
    }

}
