/*
 * ErrorJson.java
 *
 * Created on 28-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.view.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Description the class ErrorJson - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 28/01/2019
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@Component
public class ErrorJson {

    private Integer status;
    private String error;

    @JsonIgnore
    private String message;
    private String timeStamp;
    private String trace;

    /**
     * Construtor de error json.
     * @param status
     * @param errorAttributes
     */
    public ErrorJson(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
        this.timeStamp = errorAttributes.get("timestamp").toString();
        this.trace = (String) errorAttributes.get("trace");
    }

    /**
     * Recuperar error json.
     */
    public ErrorJson() {
    }
    
}
