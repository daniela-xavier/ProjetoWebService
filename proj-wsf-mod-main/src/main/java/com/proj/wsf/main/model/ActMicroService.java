/*
 * ActMicroService.java
 *
 * Created on 29-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.main.model;

import javax.persistence.EmbeddedId;

/**
 * Description the class  ActMicroService - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 29/01/2019
 */
public class ActMicroService {
    
    @EmbeddedId
    private ActMicroServiceId id;
    
    

}
