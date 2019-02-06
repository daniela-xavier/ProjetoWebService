/*
 * MicroServiceController.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.main.view;

import com.proj.wsf.main.model.MicroService;
import com.proj.wsf.view.controller.DomainEntityController;
import io.swagger.annotations.ApiOperation;
import javax.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description the class  MicroServiceController - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Controller(value = "microServiceController")
@RequestMapping("/microService")
public class MicroServiceController extends DomainEntityController<MicroService> {

    public MicroServiceController() {
        super(MicroService.class);
    }

    
    /**
     * Método para requisições GET com parametro id preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param id - Identificador da classe.
     * @return ResponseEntity - Entidade resposta.
     */
    @GetMapping(value = "{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Retorna o microService")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity getEntityById(@PathVariable String id) {
        return super.getEntityById(id);
    }

    /**
     * Método para requisições GET com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe
     * @return ResponseEntity - ResponseBody.
     */
    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Retorna uma lista de MicroService")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity getEntityByFiltro(@RequestBody MicroService entity) {
        return super.getEntityByFiltro(entity);
    }

    /**
     * Método para requisições POST com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Cria um microService")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity createEntity(@RequestBody MicroService entity) {
        return super.createEntity(entity);
    }

    /**
     * Método para requisições PUT com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Altera o microService")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity updateEntity(@RequestBody MicroService entity) {
        return super.updateEntity(entity);
    }

    /**
     * Método para requisições DELETE com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param id - Identificador da classe.
     * @return ResponseEntity - RequestBody.
     */
    @DeleteMapping(value = "{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Deleta um microService")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity deleteEntity(@PathVariable String id) {
        return super.deleteEntity(id);
    }

    
     /**
     * Método para requisições DELETE com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="Desativa um microService")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity disableEntity(@RequestBody MicroService entity) {
        return super.disableEntity(entity);
    }
    
    
}

