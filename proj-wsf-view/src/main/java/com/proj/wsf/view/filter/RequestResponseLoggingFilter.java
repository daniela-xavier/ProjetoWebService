/*
 * RequestResponseLoggingFilter.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.view.filter;

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
 * Description the class  RequestResponseLoggingFilter - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component
@Order(2)
public class RequestResponseLoggingFilter implements Filter {
   /**
     * Logging todo o request da aplicação para auditoria
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
    
    @Override
    public void doFilter(
      ServletRequest request, 
      ServletResponse response, 
      FilterChain chain) throws IOException, ServletException {
  
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        LOGGER.info(
          "Logging Request  {} : {}", req.getMethod(), 
          req.getRequestURI());
        chain.doFilter(request, response);
        LOGGER.info(
          "Logging Response :{}", 
          res.getContentType());
    }
 
  

    @Override
    public void init(FilterConfig fc) throws ServletException {
         LOGGER.info("Init filtro de RequestResponse");
    }

    @Override
    public void destroy() {       
        LOGGER.warn("Destroy filtro de RequestResponse");
    }
}
