/*
 * IRepository.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.core;

import com.proj.wsf.model.DomainEntity;
import java.util.List;

/**
 * Description the class  IRepository - Classe que contém o contrato para as
 * implementações de Repository.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
public interface IRepository {

    
     //Toda classe Repository deve conter a anotação.     
     // @Component("<nameEntity>Repository")    
    
    
    /**
     * Método que salva a entidade fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> save(DomainEntity entity);

    /**
     * Método que altera a entidade fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> update(DomainEntity entity);

    /**
     * Método que deleta a entidade, por meio do id fornecido no método.
     *
     * @param id
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> delete(Long id);
    
     /**
     * Método que desativa a entidade fornecida no método.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> disable(DomainEntity entity);

    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> findByFilter(DomainEntity entity);

    /**
     * Método que busca a entidade fornecida, com filtro em seus atributos.
     *
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> findAll();

    /**
     * Método que busca a entidade, por meio do id fornecido.
     *
     * @param id
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> findById(Long id);

}

