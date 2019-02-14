/*
 * DateNotNullValidator.java
 *
 * Created on 12-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */
package com.proj.wsf.model.anotations.validator;

import com.proj.wsf.model.anotations.DateNotNull;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Description the class DateNotNullValidator - Validador de date nula.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 12/02/2019
 */
public class DateNotNullValidator implements ConstraintValidator<DateNotNull, Date> {

    @Override
    public void initialize(DateNotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        if (date == null) {
            return true;
        }             
        return false;
    }

}
