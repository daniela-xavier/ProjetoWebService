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
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description the class  DomainEntityController -  Classe responsével pela
 * execução das açães, de acordo com métodos HTTP.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
@Controller(value = "domainEntityController")
public class DomainEntityController<T extends DomainEntity> extends BaseController {

    /**
     * Variável para o padrão facade.
     */
    @Autowired
    @Qualifier("facade")
    protected IFacade fachada;

    /**
     * Variável para os mapas de serviços das classes.
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
     * Método para requisiçães GET com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @return ModelAndView - pagina WEB de Bem vindo.
     */
    @RequestMapping(path = "/testFoz", method = RequestMethod.GET)    
    public ModelAndView getTestWebService() {  
        return new ModelAndView("WebServiceAreaRestrita");
    }

    /**
     * Método para requisiçães GET com parametro id preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param id - Identificador da classe.
     * @return ResponseEntity - Entidade resposta.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Transactional
    public @ResponseBody
    ResponseEntity getEntityById(@PathVariable Long id) {

        try {
            IServico entidadeServico = getServico(clazz.getSimpleName());
            Result resultado = fachada.findById(id, entidadeServico);
            Iterable<DomainEntity> t = resultado.getEntity();

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
    @RequestMapping(method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
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
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
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
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
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
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Transactional
    public @ResponseBody
    ResponseEntity deleteEntity(@PathVariable Long id) {

        try {
            IServico entidadeServico = getServico(clazz.getSimpleName());
            Result resultado = fachada.delete(id, entidadeServico);
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