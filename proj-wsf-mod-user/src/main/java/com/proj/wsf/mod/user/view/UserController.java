/*
 * UserController.java
 *
 * Created on 05-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.mod.user.view;

import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.view.controller.DomainEntityController;
import io.swagger.annotations.Api;
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
import org.springframework.web.bind.annotation.RestController;

/**
 * Description the class UserController - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 05/02/2019
 */
@RestController
@Controller(value = "userController")
@RequestMapping("/user")
@Api(value = "API REST FOZ - USER")
public class UserController extends DomainEntityController<User> {

    /**
     * Construtor da classe
     */
    public UserController() {
        super(User.class);
    }

    /**
     * Método para requisições GET com parametro id preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param id - Identificador da classe.
     * @return ResponseEntity - Entidade resposta.
     */
    @GetMapping(value = "{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Retorna a entidade usuário")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity getEntityById(@PathVariable final String id) {
        return super.getEntityById(id);
    }

    /**
     * Método para requisições GET com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe
     * @return ResponseEntity - ResponseBody.
     */
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Retorna uma lista de usuários")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity getEntityByFiltro(@RequestBody final User entity) {
        return super.getEntityByFiltro(entity);
    }

    /**
     * Método para requisições POST com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Cria um usuário no sistema")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity createEntity(@RequestBody final User entity) {
        return super.createEntity(entity);
    }

    /**
     * Método para requisições PUT com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Altera o usuario enviado")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity updateEntity(@RequestBody final User entity) {
        return super.updateEntity(entity);
    }

    /**
     * Método para requisições DELETE com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param id - Identificador da classe.
     * @return ResponseEntity - RequestBody.
     */
    @DeleteMapping(value = "{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Deleta uma entidade")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity deleteEntity(@PathVariable final String id) {
        return super.deleteEntity(id);
    }

    /**
     * Método para requisições DELETE com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Desativa uma entidade")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity disableEntity(@RequestBody final User entity) {
        return super.disableEntity(entity);
    }

}
