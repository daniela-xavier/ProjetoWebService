/*
 * DomainEntityController.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.view.controller;

import com.proj.wsf.view.response.ResponseMessage;
import com.proj.wsf.view.response.ExceptionResponse;
import com.proj.wsf.core.IFacade;
import com.proj.wsf.core.IServico;
import com.proj.wsf.core.application.Result;
import com.proj.wsf.model.DomainEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description the class DomainEntityController - Classe responsével pela
 * execução das açães, de acordo com métodos HTTP.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 23/01/2019
 */
@RestController
@RequestMapping(value="/api/v1")
@Api(value="API REST FOZ")
@Controller(value = "domainEntityController")
public class DomainEntityController<T extends DomainEntity> extends BaseController {

    /**
     * Variavel para o padrao facade.
     */
    @Autowired
    @Qualifier("facade")
    protected IFacade fachada;

    /**
     * Variavel para os mapas de servicos das classes.
     */
    @Autowired
    protected Map<String, IServico> servico;

    /**
     * Classe de cada entidade instanciada.
     */
    protected Class<? extends T> clazz;

    /**
     * Construtor da classe com parametros de classe Entity.
     *
     * @param clazz - Classe da entidade
     */
    public DomainEntityController(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Construtor da classe sem parametros.
     */
    public DomainEntityController() {
    }

    
    /**
     * Método para requisiçães GET com parametro id preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param id - Identificador da classe.
     * @return ResponseEntity - Entidade resposta.
     */
    @GetMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="Retorna uma entidade")
    @Transactional
    public @ResponseBody
    ResponseEntity getEntityById(@PathVariable String id) {
    Long longId = Long.parseLong(id);

        try {
            IServico entidadeServico = getServico(clazz.getSimpleName());
            Result resultado = fachada.findById(longId, entidadeServico);
            Iterable<DomainEntity> t = resultado.getEntity();

            if (resultado.hasError()) {
                return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, resultado.getMsg()),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
            return new ResponseEntity<>(t, HttpStatus.OK);

        } catch (ExceptionResponse e) {
            return new ResponseEntity<>(
                    new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println("Error.: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Método para requisiçães GET com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe
     * @return ResponseEntity - ResponseBody.
     */
    @GetMapping( consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="Retorna uma lista de entidades")
    @Transactional
    public @ResponseBody
    ResponseEntity getEntityByFiltro(@RequestBody T entity) {

        try {
            IServico entidadeServico = getServico(clazz.getSimpleName());
            Result resultado = fachada.FindByFilter(entity, entidadeServico);

            if (resultado.hasError()) {
                return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, resultado.getMsg()),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(resultado, HttpStatus.OK);

        } catch (ExceptionResponse e) {
            return new ResponseEntity<>(
                    new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println("Error.: " + e.getMessage());
            return new ResponseEntity<>(
                    new ResponseMessage(Boolean.TRUE, "Erro ao cadastrar ".concat(clazz.getSimpleName().toLowerCase())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Método para requisiçães POST com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @PostMapping( consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="Cria uma entidade")
    @Transactional
    public @ResponseBody
    ResponseEntity createEntity(@RequestBody T entity) {

        try {
            IServico entidadeServico = getServico(clazz.getSimpleName());
            Result resultado = fachada.save(entity, entidadeServico);

            if (resultado.hasError()) {
                return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, resultado.getMsg()),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(entity, HttpStatus.OK);

        } catch (ExceptionResponse e) {
            return new ResponseEntity<>(
                    new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println("Error.: " + e.getMessage());
            return new ResponseEntity<>(
                    new ResponseMessage(Boolean.TRUE, "Erro ao cadastrar ".concat(clazz.getSimpleName().toLowerCase())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Método para requisiçães PUT com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @PutMapping( consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="Altera uma entidade")
    @Transactional
    public @ResponseBody
    ResponseEntity updateEntity(@RequestBody T entity) {

        try {
            IServico entidadeServico = getServico(clazz.getSimpleName());
            Result resultado = fachada.update(entity, entidadeServico);

            if (resultado.hasError()) {
                return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, resultado.getMsg()),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(entity, HttpStatus.OK);

        } catch (ExceptionResponse e) {
            return new ResponseEntity<>(
                    new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println("Error.: " + e.getMessage());
            return new ResponseEntity<>(
                    new ResponseMessage(Boolean.TRUE, "Erro ao atualizar ".concat(clazz.getSimpleName().toLowerCase())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Método para requisiçães DELETE com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param id - Identificador da classe.
     * @return ResponseEntity - RequestBody.
     */
    @DeleteMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="Deleta uma entidade")
    @Transactional
    public @ResponseBody
    ResponseEntity deleteEntity(@PathVariable String id) {
    Long longId = Long.parseLong(id);
        try {
            IServico entidadeServico = getServico(clazz.getSimpleName());
            Result resultado = fachada.delete(longId, entidadeServico);
            Iterable<DomainEntity> t = resultado.getEntity();

            return new ResponseEntity<>(resultado, HttpStatus.OK);

        } catch (ExceptionResponse e) {
            return new ResponseEntity<>(
                    new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println("Error.: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    /**
     * Método para requisiçães DELETE com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @DeleteMapping( consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="Desativa uma entidade")
    @Transactional
    public @ResponseBody
    ResponseEntity disableEntity(@RequestBody T entity) {
      try {
            IServico entidadeServico = getServico(clazz.getSimpleName());
            Result resultado = fachada.disable(entity, entidadeServico);

            if (resultado.hasError()) {
                return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, resultado.getMsg()),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(entity, HttpStatus.OK);

        } catch (ExceptionResponse e) {
            return new ResponseEntity<>(
                    new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println("Error.: " + e.getMessage());
            return new ResponseEntity<>(
                    new ResponseMessage(Boolean.TRUE, "Erro ao atualizar ".concat(clazz.getSimpleName().toLowerCase())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Método que recupera o Servico de acordo com nome da classe.
     *
     * @param nomeClasse - Nome da classe da entidade.
     * @return service - Servico da classe.
     */
    private IServico getServico(String nomeClasse) {
        String service = nomeClasse.toLowerCase().concat("Service");

        if (servico.containsKey(service)) {
            return servico.get(service);
        } else {
            throw new ExceptionResponse("Execução não permitida.");
        }

    }
}
