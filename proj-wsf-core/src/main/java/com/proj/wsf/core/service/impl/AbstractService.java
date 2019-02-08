/*
 * AbstractService.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core.service.impl;

import com.proj.wsf.model.anotations.ADomainEntity;

/**
 * Description the class  AbstractService - Classe que implementa o retorno dos
 * atributos da anotação @ADomainEntity
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public abstract class AbstractService {

    /**
     * Método que recupera a classe de <DomainEntity>Service.class instanciada.
     *
     * @return Classe<DomainEntity>
     */
    public Class<?> getClasse() {

        ADomainEntity annotation = this.getClass().getAnnotation(ADomainEntity.class);
        if (annotation != null) {
            return annotation.classe();
        }

        return null;
    }

    /**
     * Método que recupera o nome da entidade de <DomainEntity>Service.class
     * instanciada.
     *
     * @return <DomainEntity>
     */
    public String getEntidadeNome() {

        ADomainEntity annotation = this.getClass().getAnnotation(ADomainEntity.class);
        if (annotation != null) {
            return annotation.nome();
        }

        return null;
    }

}


