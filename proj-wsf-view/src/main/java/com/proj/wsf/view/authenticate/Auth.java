/*
 * Auth.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.view.authenticate;

import com.proj.wsf.core.util.JWTUtilToken;
import com.proj.wsf.model.DomainEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import javax.servlet.http.HttpServletRequest;

/**
 * Description the class Auth - Classe que retorna a validação da
 * autenticação da aplicação.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 23/01/2019
 */
public class Auth {

    /**
     * Metodo que verifica a autenticidade do token enviado e retorna a entidade
     * que estao solicitando.
     *
     * @param request - HttpServletRequest solicitada.
     * @return DomainEntity
     */
    public static DomainEntity getUserToken(HttpServletRequest request) {
        String token = request.getHeader(JWTUtilToken.TOKEN_HEADER_AUTHENTICATION);
        DomainEntity me = new DomainEntity();
        if (token != null) {

            Jws<Claims> jws = JWTUtilToken.decodificarToken(token);
            if (jws != null) {
                String user = jws.getBody().getSubject();
                System.out.println("User request: " + user);
                me.setUser(user);
                me.setTk(token);
                return me;
            }
        }
        return null;
    }

    /**
     * Metodo que verifica a autenticidade do token enviado e retorna a entidade
     * que estao solicitando.
     *
     * @param request - HttpServletRequest solicitada.
     * @return DomainEntity
     */
    public static Boolean getValidUser(HttpServletRequest request) {
        String token = request.getHeader(JWTUtilToken.TOKEN_HEADER_AUTHENTICATION);

        if (token != null) {
            Jws<Claims> jws;
            try {
                jws = JWTUtilToken.decodificarToken(token);
            } catch (Exception e) {
                return true;
            }

            if (jws != null) {
                String user = jws.getBody().getSubject();
                if (user != null || !user.isEmpty()) {                    
                   
                    return true;
                }

            }
            return true;
        }
        return true;
    }
}
