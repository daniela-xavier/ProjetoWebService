/*
 * TemplateHtmlController.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.view;

import com.proj.wsf.mod.email.model.TemplateHtml;
import com.proj.wsf.model.interfaces.OnDisable;
import com.proj.wsf.model.interfaces.OnFindFilter;
import com.proj.wsf.model.interfaces.OnSave;
import com.proj.wsf.model.interfaces.OnUpdate;
import com.proj.wsf.view.controller.DomainEntityController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
 * Description the class  TemplateHtmlController - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@RestController
@Controller(value = "templateHtmlController")
@RequestMapping("/template_html")
@Api(value = "API REST FOZ - TEMPLATE HTML")
@Validated
public class TemplateHtmlController extends DomainEntityController<TemplateHtml> {

    /**
     * Construtor da classe
     */
    public TemplateHtmlController() {
        super(TemplateHtml.class);
    }

    /**
     * Método para requisições GET com parametro idTemplateHtml preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param idTemplateHtml - Identificador da classe.
     * @return ResponseEntity - Entidade resposta.
     */
    @GetMapping(value = "{idTemplateHtml}", 
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "Retorna o evento do sistema")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity getEntityById(@PathVariable final Optional<String> idTemplateHtml) {
        return super.getEntityById(idTemplateHtml);
    }

    /**
     * Método para requisições GET com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe
     * @return ResponseEntity - ResponseBody.
     */
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "Retorna uma lista de eventos do sistema")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity getEntityByFiltro(@Validated(OnFindFilter.class) @RequestBody TemplateHtml entity, BindingResult result) {
        return super.getEntityByFiltro(entity, result);
    }

    /**
     * Método para requisições POST com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "Cria um evento do sistema")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity createEntity(@Validated(OnSave.class) @RequestBody TemplateHtml entity, BindingResult result) {
        return super.createEntity(entity, result);
    }

    /**
     * Método para requisições PUT com parametro entity preenchido, que aceita
     * entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "Altera o evento do sistema")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity updateEntity(@Validated(OnUpdate.class) @RequestBody TemplateHtml entity, BindingResult result) {
        return super.updateEntity(entity, result);
    }

    /**
     * Método para requisições DELETE com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param idTemplateHtml - Identificador da classe.
     * @return ResponseEntity - RequestBody.
     */
    @DeleteMapping(value = "{idTemplateHtml}", 
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "Deleta um evento do sistema")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity deleteEntity(@PathVariable Optional<String> idTemplateHtml) {
        return super.deleteEntity(idTemplateHtml);
    }

    /**
     * Método para requisições DELETE com parametro entity preenchido, que
     * aceita entradas em JSON e retorno em JSON.
     *
     * @param entity - RequestBody Entidade da classe.
     * @return ResponseEntity - RequestBody.
     */
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "Desativa um evento do sistema")
    @Transactional
    @Override
    public @ResponseBody
    ResponseEntity disableEntity(@Validated(OnDisable.class) @RequestBody TemplateHtml entity, BindingResult result) {
        return super.disableEntity(entity, result);
    }

}
