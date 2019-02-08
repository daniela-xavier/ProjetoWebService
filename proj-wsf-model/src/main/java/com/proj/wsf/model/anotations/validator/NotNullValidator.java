/*
 * NotNullValidator.java
 *
 * Created on 08-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.model.anotations.validator;

import com.proj.wsf.model.anotations.NotNull;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

/**
 * Description the class NotNullValidator - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 08/02/2019
 */
public class NotNullValidator implements ConstraintValidator<NotNull, String> {

    private String value;

    @Override
    public void initialize(NotNull constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        return StringUtils.isEmpty(value);

    }
}
