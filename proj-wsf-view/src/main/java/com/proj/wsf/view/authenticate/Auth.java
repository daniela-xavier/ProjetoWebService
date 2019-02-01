/*
 * Auth.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.view.authenticate;

import com.proj.wsf.model.DomainEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import javax.servlet.http.HttpServletRequest;

/**
 * Description the class  Auth - Classe que retorna a validação da autenticação
 * da aplicação.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public class Auth {

    /**
     * Método que verifica a autenticidade do token enviado e retorna a entidade
     * que está solicitando.
     *
     * @param request - HttpServletRequest solicitada.
     * @return DomainEntity
     */
    public static DomainEntity authToken(HttpServletRequest request) {
        String token = request.getHeader(JWTUtilToken.TOKEN_HEADER_AUTHENTICATION);
        DomainEntity me = new DomainEntity();
        if (token != null) {

            Jws<Claims> jws = JWTUtilToken.decodificarToken(token);
            if (jws != null) {
                String user = jws.getBody().getSubject();
                System.out.println("User request: " + user);                
                me.setUser(user);
                me.setToken(token);
                return me;
            }
        }
        return null;
    }
}

