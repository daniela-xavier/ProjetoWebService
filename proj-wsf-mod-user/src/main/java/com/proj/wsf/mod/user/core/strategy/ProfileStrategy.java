/*
 * ProfileStrategy.java
 *
 * Created on 05-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.wsf.mod.user.core.strategy;

import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.strategy.impl.DisableAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Description the class ProfileStrategy - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 05/02/2019
 */
@Component("profileStrategy")
public class ProfileStrategy {

    Map<String, List<IStrategy>> rnsProfile = new HashMap<>();

    public ProfileStrategy() {
        //Regras para entidade profile    
        DisableAction desabilitarAcao = new DisableAction();

        /* Criando uma lista para conter as regras de negocio de Profile
         * quando a operacao for salvar
         */
        List<IStrategy> rnsSalvarProfile = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do Profile */
        rnsSalvarProfile.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de Profile
         * quando a operacao for alterar
         */
        List<IStrategy> rnsAlterarProfile = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do Profile */
        rnsAlterarProfile.add(desabilitarAcao);


        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for alterar
         */
        List<IStrategy> rnsConsultarProfile = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao consultar do Profile */
        rnsConsultarProfile.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for excluir
         */
        List<IStrategy> rnsExcluirProfile = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao excluir do Profile */
        rnsExcluirProfile.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for visualizar
         */
        List<IStrategy> rnsVisualizarProfile = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao visualizar do Profile */
        rnsVisualizarProfile.add(desabilitarAcao);
        
        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for desativar
         */
        List<IStrategy> rnsDesativarProfile = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao desativar do Profile */
        rnsDesativarProfile.add(desabilitarAcao);

        /*
         * Adiciona a listra de regras na operacao salvar no mapa do Profile 
         */
        rnsProfile.put("SALVAR", rnsSalvarProfile);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do Profile 
         */
        rnsProfile.put("ALTERAR", rnsAlterarProfile);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do Profile 
         */
        rnsProfile.put("CONSULTAR", rnsConsultarProfile);
        /*
         * Adiciona a listra de regras na operacao excluir no mapa do Profile 
         */
        rnsProfile.put("EXCLUIR", rnsExcluirProfile);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do Profile 
         */
        rnsProfile.put("VISUALIZAR", rnsVisualizarProfile);
        /*
         * Adiciona a listra de regras na operacao desativar no mapa do Profile 
         */
        rnsProfile.put("DESATIVAR", rnsDesativarProfile);

    }

    public Map<String, List<IStrategy>> getRnsProfile() {
        return rnsProfile;
    }

}
