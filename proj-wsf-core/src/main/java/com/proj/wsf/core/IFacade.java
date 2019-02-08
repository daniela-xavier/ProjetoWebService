/*
 * IFacade.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core;

import com.proj.wsf.core.application.Result;
import com.proj.wsf.model.DomainEntity;
import org.springframework.stereotype.Component;

/**
 * Description the class  IFacade - Classe de padronização para implementação de
 padrão fachada.
 * @author Daniela Xavier Conceição - 
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
@Component
public interface IFacade {

    /**
     * Método que salva entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result save(DomainEntity entity, IServico service);

    /**
     * Método que altera entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result update(DomainEntity entity, IServico service);

    /**
     * Método que delete entity.
     *
     * @param id
     * @param service
     * @return Result
     */
    public Result delete(Long id, IServico service);
    
    /**
     * Método que desativa entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result disable(DomainEntity entity, IServico service);

    /**
     * Método que consulta entity.
     *
     * @param classe 
     * @param service
     * @return Result
     */
    public Result findAll(Class classe, IServico service);
    /**
     * Método que consulta entity.
     *
     * @param id 
     * @param service
     * @return Result
     */
    public Result findById(Long id, IServico service);
    /**
     * Método que consulta entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result FindByFilter(DomainEntity entity, IServico service);
    
   
    /**
     * Método que visualiza entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result view(DomainEntity entity, IServico service);

}

