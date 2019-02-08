/*
 * ProfileController.java
 *
 * Created on 05-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.mod.user.view;

import com.proj.wsf.mod.user.model.Profile;
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
 * Description the class ProfileController - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 05/02/2019
 */
@RestController
@Controller(value = "profileController")
@RequestMapping("/profile")
@Api(value = "API REST FOZ - PROFILE")
public class ProfileController extends DomainEntityController<Profile> {

    /**
     * Construtor da classe
     */
    public ProfileController() {
        super(Profile.class);
    }

    /**
     * Método para requisições GET com parametro idProfile preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param idProfile - Identificador da classe.
     * @return ResponseEntity - Entidade resposta.
     */
    @GetMapping(value = "{idProfile}", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Retorna a entidade perfil")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity getEntityById(@PathVariable final String idProfile) {
        return super.getEntityById(idProfile);
    }

    /**
     * Método para requisições GET com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe
     * @return ResponseEntity - ResponseBody.
     */
    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Retorna uma lista de perfils")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity getEntityByFiltro(@RequestBody final Profile entity) {
        return super.getEntityByFiltro(entity);
    }

    /**
     * Método para requisições POST com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Cria um perfil no sistema")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity createEntity(@RequestBody final Profile entity) {
        return super.createEntity(entity);
    }

    /**
     * Método para requisições PUT com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Altera o perfil enviado")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity updateEntity(@RequestBody final Profile entity) {
        return super.updateEntity(entity);
    }

    /**
     * Método para requisições DELETE com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param idProfile - Identificador da classe.
     * @return ResponseEntity - RequestBody.
     */
    @DeleteMapping(value = "{idProfile}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Deleta um perfil")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity deleteEntity(@PathVariable final String idProfile) {
        return super.deleteEntity(idProfile);
    }

    /**
     * Método para requisições DELETE com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Desativa um perfil")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity disableEntity(@RequestBody final Profile entity) {
        return super.disableEntity(entity);
    }

}
