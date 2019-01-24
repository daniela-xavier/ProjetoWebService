/*
 * MainConfigurationStrategy.java
 *
 * Created on 24-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
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
 * Description the class  MainConfigurationStrategy - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("mainConfigurationStrategy")
public class MainConfigurationStrategy {

    Map<String, List<IStrategy>> rnsMainConfiguration = new HashMap<>();

    public MainConfigurationStrategy() {
        //Regras para entidade MainConfiguration    
        DisableAction desabilitarAcao = new DisableAction();

     
        /* Criando uma lista para conter as regras de negocio de MainConfiguration
         * quando a operacao for salvar
         */
        List<IStrategy> rnsSalvarMainConfiguration = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do MainConfiguration */
        rnsSalvarMainConfiguration.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de MainConfiguration
         * quando a operacao for alterar
         */
        List<IStrategy> rnsAlterarMainConfiguration = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do MainConfiguration */
        rnsAlterarMainConfiguration.add(desabilitarAcao);


        /* Criando uma lista para conter as regras de negocio de mainConfiguration
         * quando a operacao for alterar
         */
        List<IStrategy> rnsConsultarMainConfiguration = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao consultar do MainConfiguration */
        rnsConsultarMainConfiguration.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de mainConfiguration
         * quando a operacao for excluir
         */
        List<IStrategy> rnsExcluirMainConfiguration = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao excluir do MainConfiguration */
        rnsExcluirMainConfiguration.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de mainConfiguration
         * quando a operacao for visualizar
         */
        List<IStrategy> rnsVisualizarMainConfiguration = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao visualizar do MainConfiguration */
        rnsVisualizarMainConfiguration.add(desabilitarAcao);

        /*
         * Adiciona a listra de regras na operacao salvar no mapa do MainConfiguration 
         */
        rnsMainConfiguration.put("SALVAR", rnsSalvarMainConfiguration);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do MainConfiguration 
         */
        rnsMainConfiguration.put("ALTERAR", rnsAlterarMainConfiguration);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do MainConfiguration 
         */
        rnsMainConfiguration.put("CONSULTAR", rnsConsultarMainConfiguration);
        /*
         * Adiciona a listra de regras na operacao excluir no mapa do MainConfiguration 
         */
        rnsMainConfiguration.put("EXCLUIR", rnsExcluirMainConfiguration);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do MainConfiguration 
         */
        rnsMainConfiguration.put("VISUALIZAR", rnsVisualizarMainConfiguration);

    }

    public Map<String, List<IStrategy>> getRnsMainConfiguration() {
        return rnsMainConfiguration;
    }

}

