/*
 * JWTUtilToken.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;

/**
 * Description the class  JWTUtilToken - Classe que auxilia nas operaÃ§Ãµs
 * realizadas com token.
 * @author Daniela Xavier Conceicao - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public abstract class JWTUtilToken {

    //Variavel de configuracao do token.    

    /**
     *
     */
    public static final String KEY = "CONTINUE_A_NADAR";

    //Variavel de auditoria do token.

    /**
     *
     */
    public static final String AUD = "PARA_ACHAR_A_SOLUCAO_NADAR";

    //Variavel de identificacao do token no header da requisicao.    

    /**
     *
     */
    public static final String TOKEN_HEADER_AUTHENTICATION = "Authentication";

    //Variavel identificadora da plataforma.

    /**
     *
     */
    public static final String TOKEN_HEADER_API = "APIAuthentication";

    /**
     * Metodo que cria a String do token.
     *
     * @param subject - sujeito do token.
     * @return String
     */
    public static String criarToken(String subject) {
        String token = "";
        try {            
            token = Jwts.builder()
                    .setSubject(subject)
                    .setAudience(AUD)
                    .signWith(SignatureAlgorithm.HS512, KEY)
                    .compact();
        } catch (Exception e) {
            return("Não foi possivel realizar a criação do token. Exception" + e.getMessage());
        }
        return token;
    }
    
    /**
     * Metodo que decodifica o token e retorna um JWS com os atributos
     * para validacao.
     *
     * @param token - Token enviado.
     * @return JWS
     */
    public static Jws<Claims> decodificarToken(String token) {
        if (validarToken(token)) {
            return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
        }
        return null;
    }

    /**
     * Metodo que renova o token de acordo com as entradas passada.
     *
     * @param token - Token enviado.
     * @param subject - Sujeito do token.
     * @return String.
     */
    public static String renovarToken(String token, String subject) {
        Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
        Date expiration = parseClaimsJws.getBody().getExpiration();

        if (expiration.after(Calendar.getInstance().getTime())) {
            return criarToken(subject);
        }
        return null;
    }

    /**
     * Metodo que faz a validacao do token de acordo com o a palavra Passe.
     *
     * @param token - Token enviado.
     * @return boolean
     */
    public static boolean validarToken(String token) {
        Jws<Claims> jws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
        return jws.getBody().getAudience().equals(AUD);
    }
}

