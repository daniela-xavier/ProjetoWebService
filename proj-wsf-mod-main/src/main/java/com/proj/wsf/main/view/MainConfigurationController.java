/*
 * MainConfigurationController.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.main.view;

import com.proj.wsf.core.IServico;
import com.proj.wsf.core.application.Result;
import com.proj.wsf.main.model.MainConfiguration;
import com.proj.wsf.model.DomainEntity;
import com.proj.wsf.view.controller.DomainEntityController;
import com.proj.wsf.view.response.ExceptionResponse;
import com.proj.wsf.view.response.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description the class  MainConfigurationController - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Controller(value = "mainConfigurationController")
@RequestMapping("/mainConfiguration")
@CrossOrigin(origins = "*")
@Api(value="MAIN CONFIG API REST FOZ")
public class MainConfigurationController extends DomainEntityController<MainConfiguration> {

    public MainConfigurationController() {
        super(MainConfiguration.class);
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
    @ApiOperation(value = "Retorna o MainConfiguration")
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
    @ApiOperation(value = "Retorna uma lista de MainConfigurations")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity getEntityByFiltro(@RequestBody MainConfiguration entity) {
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
    @ApiOperation(value = "Cria um MainConfiguration")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity createEntity(@RequestBody MainConfiguration entity) {
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
    @ApiOperation(value = "Altera o MainConfiguration")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity updateEntity(@RequestBody MainConfiguration entity) {
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
    @ApiOperation(value = "Deleta um MainConfiguration")
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
    @ApiOperation(value="Desativa um MainConfiguration")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity disableEntity(@RequestBody MainConfiguration entity) {
        return super.disableEntity(entity);
    }
    
    
}

