/*
 * MicroServiceStrategy.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.main.core.strategy;

import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.strategy.impl.DisableAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Description the class  MicroServiceStrategy - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("microServiceStrategy")
public class MicroServiceStrategy {

    Map<String, List<IStrategy>> rnsMicroService = new HashMap<>();

    /**
     * Contrutor da classe para inicializar as strategys.
     */
    public MicroServiceStrategy() {
        //Regras para entidade MicroService    
        DisableAction desabilitarAcao = new DisableAction();

     
        /* Criando uma lista para conter as regras de negocio de MicroService
         * quando a operacao for salvar
         */
        List<IStrategy> rnsSalvarMicroService = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do MicroService */
        rnsSalvarMicroService.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de MicroService
         * quando a operacao for alterar
         */
        List<IStrategy> rnsAlterarMicroService = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do MicroService */
        rnsAlterarMicroService.add(desabilitarAcao);


        /* Criando uma lista para conter as regras de negocio de mainConfiguration
         * quando a operacao for alterar
         */
        List<IStrategy> rnsConsultarMicroService = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao consultar do MicroService */
        rnsConsultarMicroService.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de mainConfiguration
         * quando a operacao for excluir
         */
        List<IStrategy> rnsExcluirMicroService = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao excluir do MicroService */
        rnsExcluirMicroService.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de mainConfiguration
         * quando a operacao for visualizar
         */
        List<IStrategy> rnsVisualizarMicroService = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao visualizar do MicroService */
        rnsVisualizarMicroService.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de mainConfiguration
         * quando a operacao for desativar
         */
        List<IStrategy> rnsDesativarMicroService = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao desativar do MicroService */
        rnsDesativarMicroService.add(desabilitarAcao);

        /*
         * Adiciona a listra de regras na operacao salvar no mapa do MicroService 
         */
        rnsMicroService.put("SALVAR", rnsSalvarMicroService);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do MicroService 
         */
        rnsMicroService.put("ALTERAR", rnsAlterarMicroService);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do MicroService 
         */
        rnsMicroService.put("CONSULTAR", rnsConsultarMicroService);
        /*
         * Adiciona a listra de regras na operacao excluir no mapa do MicroService 
         */
        rnsMicroService.put("EXCLUIR", rnsExcluirMicroService);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do MicroService 
         */
        rnsMicroService.put("VISUALIZAR", rnsVisualizarMicroService);
        /*
         * Adiciona a listra de regras na operacao desativar no mapa do MicroService 
         */
        rnsMicroService.put("DESATIVAR", rnsDesativarMicroService);

    }

    /**
     * Retorna regras da entidade.
     * @return Map String, List -> IStrategy
     */
    public Map<String, List<IStrategy>> getRnsMicroService() {
        return rnsMicroService;
    }

}


