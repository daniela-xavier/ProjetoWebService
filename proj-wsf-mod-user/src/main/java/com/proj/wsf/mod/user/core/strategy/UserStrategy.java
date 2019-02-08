/*
 * UserStrategy.java
 *
 * Created on 05-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
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
 * Description the class UserStrategy - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 05/02/2019
 */
@Component("userStrategy")
public class UserStrategy {

    Map<String, List<IStrategy>> rnsUser = new HashMap<>();

    /**
     * Contrutor da classe para inicializar as strategys.
     */
    public UserStrategy() {
        //Regras para entidade User    
        DisableAction desabilitarAcao = new DisableAction();

        /* Criando uma lista para conter as regras de negocio de User
         * quando a operacao for salvar
         */
        final List<IStrategy> rnsSalvarUser = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do User */
        rnsSalvarUser.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de User
         * quando a operacao for alterar
         */
        final List<IStrategy> rnsAlterarUser = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do User */
        rnsAlterarUser.add(desabilitarAcao);


        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for alterar
         */
        final List<IStrategy> rnsConsultarUser = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao consultar do User */
        rnsConsultarUser.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for excluir
         */
        final List<IStrategy> rnsExcluirUser = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao excluir do User */
        rnsExcluirUser.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for visualizar
         */
        final List<IStrategy> rnsVisualizarUser = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao visualizar do User */
        rnsVisualizarUser.add(desabilitarAcao);
        
        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for desativar
         */
        final List<IStrategy> rnsDesativarUser = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao desativar do User */
        rnsDesativarUser.add(desabilitarAcao);

        /*
         * Adiciona a listra de regras na operacao salvar no mapa do User 
         */
        rnsUser.put("SALVAR", rnsSalvarUser);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do User 
         */
        rnsUser.put("ALTERAR", rnsAlterarUser);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do User 
         */
        rnsUser.put("CONSULTAR", rnsConsultarUser);
        /*
         * Adiciona a listra de regras na operacao excluir no mapa do User 
         */
        rnsUser.put("EXCLUIR", rnsExcluirUser);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do User 
         */
        rnsUser.put("VISUALIZAR", rnsVisualizarUser);
        /*
         * Adiciona a listra de regras na operacao desativar no mapa do User 
         */
        rnsUser.put("DESATIVAR", rnsVisualizarUser);

    }

    /**
     * Retorna regras da entidade.
     * @return Map String, List -> IStrategy
     */
    public Map<String, List<IStrategy>> getRnsUser() {
        return rnsUser;
    }

}
