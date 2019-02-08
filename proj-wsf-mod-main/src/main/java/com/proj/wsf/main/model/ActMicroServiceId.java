/*
 * ActMicroServiceId.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.main.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Description the class ActMicroServiceId - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 29/01/2019
 */
@Embeddable
public class ActMicroServiceId implements Serializable {

    private Long idAct;
    private Long idMicroService;
    
    /**
     * Construtor da classe.
     */
    public ActMicroServiceId() {
    }

    /**
     * Metodo construtor do id.
     * @param idAct
     * @param idMicroService
     */
    public ActMicroServiceId(Long idAct, Long idMicroService) {
        this.idAct = idAct;
        this.idMicroService = idMicroService;
    }

    /**
     * Retorno do Id Act.
     * @return long
     */
    public Long getIdAct() {
        return idAct;
    }

    /**
     * Incluir id Act.
     * @param idAct
     */
    public void setIdAct(Long idAct) {
        this.idAct = idAct;
    }

    /**
     * Retornar Id MicroService.
     * @return long
     */
    public Long getIdMicroService() {
        return idMicroService;
    }

    /**
     * Incluir Id Micro Service.
     * @param idMicroService
     */
    public void setIdMicroService(Long idMicroService) {
        this.idMicroService = idMicroService;
    }

}
