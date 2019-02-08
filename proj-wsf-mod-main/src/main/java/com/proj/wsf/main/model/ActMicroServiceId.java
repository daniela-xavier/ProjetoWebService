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

    // must have a default construcot
    public ActMicroServiceId() {
    }

    public ActMicroServiceId(Long idAct, Long idMicroService) {
        this.idAct = idAct;
        this.idMicroService = idMicroService;
    }

    public Long getIdAct() {
        return idAct;
    }

    public void setIdAct(Long idAct) {
        this.idAct = idAct;
    }

    public Long getIdMicroService() {
        return idMicroService;
    }

    public void setIdMicroService(Long idMicroService) {
        this.idMicroService = idMicroService;
    }

}
