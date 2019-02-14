package com.proj.wsf.view.filter;

import com.proj.wsf.core.util.JWTUtilToken;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/*
 * JWTUtilTokenTest.java
 *
 * Created on 14-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

/**
 * Description the class  JWTUtilTokenTest - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 14/02/2019
 */
public class JWTUtilTokenTest {

    @Test
    public void CriarTokenTest() {
        String token = JWTUtilToken.criarToken("teste.teste");
        System.out.println("Criar Token.: " + token);
        Assertions.assertThat(token).isNotNull();
    }

}
