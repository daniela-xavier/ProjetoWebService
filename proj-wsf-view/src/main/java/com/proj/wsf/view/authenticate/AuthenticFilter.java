/*
 * AuthenticFilter.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.view.authenticate;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description the class  AuthenticFilter - Classe filtro da aplicação.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public class AuthenticFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    /**
     * Construtor da classe.
     */
    public AuthenticFilter() {
    }

    /**
     * Método do Filter responsável por verificar se requisição é válida.
     *
     * @param req The servlet request we are processing
     * @param res The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String uri = request.getRequestURI();

        chain.doFilter(request, response);

        /* if (request.getHeader("Authentication") != null) {
        
        DomainEntity entidade = Auth.authToken(request);
        
        if (entidade != null && entidade.getUser() != null) {
        chain.doFilter(request, response);
        } else {
        response.setStatus(404);
        }
        }
        response.setStatus(404);*/
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }

    /**
     * Logging todo o request da aplica��o para auditoria
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Iniciando filtro de logging");
    }

}
