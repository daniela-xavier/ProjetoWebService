/*
 * EntityApplication.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description the class  EntityApplication - Entidade da Aplicação.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public class EntityApplication {

    /**
     * Método de log das Entidades por classe.
     * @param clazz
     * @return Logger
     */
    public Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
