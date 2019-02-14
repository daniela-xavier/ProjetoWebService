/*
 * RequestResponseLoggingFilter.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.view.filter;

import com.proj.wsf.view.authenticate.Auth;
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
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description the class RequestResponseLoggingFilter - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component
@Order(1)
public class AuthenticFilter implements Filter {

    /**
     * Logging todo o request da aplicação para auditoria
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticFilter.class);
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println("URI: "+req.getRequestURI());
        if (!req.getRequestURI().endsWith(".html") && !req.getRequestURI().endsWith(".js") && !req.getRequestURI().endsWith(".css")
                && !req.getRequestURI().contains("swagger") && !req.getRequestURI().endsWith("api-docs")) {
            if (req.getHeader("Authentication") == null || Auth.getValidUser(req)) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setContentType(CONTENT_TYPE);
                httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Required headers not specified in the request");
                return;
            }
        }
        chain.doFilter(request, response);

    }

    /**
     *
     * @param fc
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig fc) throws ServletException {
        LOGGER.info("Init filtro");
        System.out.println("Iniciando filtro");
    }

    /**
     * Destroi filtro de request response.
     */
    @Override
    public void destroy() {
        LOGGER.warn("Destroy filtro");
    }
}
