/*
 * Rule.java
 *
 * Created on 14-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */
package com.proj.wsf.model;

/**
 * Description the class Rule - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 14/02/2019
 */
public class Rule {

    private String rule;
    private String action;
    private Boolean permitido;

    public Rule() {
    }

    public String getRule() {
        return rule;
    }

    public String getAction() {
        return action;
    }

    public Boolean getPermitido() {
        return permitido;
    }

    
    
}
