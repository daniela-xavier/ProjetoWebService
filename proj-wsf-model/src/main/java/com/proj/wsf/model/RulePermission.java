/*
 * RulePermission.java
 *
 * Created on 14-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */
package com.proj.wsf.model;

/**
 * Description the class RulePermission - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 14/02/2019
 */
public abstract class RulePermission {

    public Boolean findPermissionUser(String user, String action, String uri) {
        
        //Pesquisar rule que contenha o usuario, para a acao e a uri
        
        return true;
    }
    
    public static  Boolean findRuleUser(String user, String action, String uri) {
        
        //Pesquisar rule que contenha o usuario, para a acao e a uri
        
        return true;
    }
}
