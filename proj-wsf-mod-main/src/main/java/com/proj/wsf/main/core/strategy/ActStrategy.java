/*
 * ActStrategy.java
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
 * Description the class  ActStrategy - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 24/01/2019
 */
@Component("actStrategy")
public class ActStrategy {

    Map<String, List<IStrategy>> rnsAct = new HashMap<>();

    public ActStrategy() {
        //Regras para entidade Act    
        DisableAction desabilitarAcao = new DisableAction();

     
        /* Criando uma lista para conter as regras de negocio de Act
         * quando a operacao for salvar
         */
        List<IStrategy> rnsSalvarAct = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do Act */
        rnsSalvarAct.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de Act
         * quando a operacao for alterar
         */
        List<IStrategy> rnsAlterarAct = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do Act */
        rnsAlterarAct.add(desabilitarAcao);


        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for alterar
         */
        List<IStrategy> rnsConsultarAct = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao consultar do Act */
        rnsConsultarAct.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for excluir
         */
        List<IStrategy> rnsExcluirAct = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao excluir do Act */
        rnsExcluirAct.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for visualizar
         */
        List<IStrategy> rnsVisualizarAct = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao visualizar do Act */
        rnsVisualizarAct.add(desabilitarAcao);
        
        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for desativar
         */
        List<IStrategy> rnsDesativarAct = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao desativar do Act */
        rnsDesativarAct.add(desabilitarAcao);

        /*
         * Adiciona a listra de regras na operacao salvar no mapa do Act 
         */
        rnsAct.put("SALVAR", rnsSalvarAct);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do Act 
         */
        rnsAct.put("ALTERAR", rnsAlterarAct);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do Act 
         */
        rnsAct.put("CONSULTAR", rnsConsultarAct);
        /*
         * Adiciona a listra de regras na operacao excluir no mapa do Act 
         */
        rnsAct.put("EXCLUIR", rnsExcluirAct);
        /*
         * Adiciona a listra de regras na operacao desativar no mapa do Act 
         */
        rnsAct.put("DESATIVAR", rnsDesativarAct);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do Act 
         */
        rnsAct.put("VISUALIZAR", rnsVisualizarAct);

    }

    public Map<String, List<IStrategy>> getRnsAct() {
        return rnsAct;
    }

}

