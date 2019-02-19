/*
 * ComunicacaoEmailStrategy.java
 *
 * Created on 19-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.mod.email.core.strategy;

import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.strategy.impl.DisableAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Description the class  ComunicacaoEmailStrategy - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Component("comunicacaoEmailStrategy")
public class ComunicacaoEmailStrategy {
    Map<String, List<IStrategy>> rnsComunicacaoEmail = new HashMap<>();

    /**
     * Contrutor da classe para inicializar as strategys.
      * @param disableAction - Strategy que desabilita a operação.
     */
    public ComunicacaoEmailStrategy(DisableAction disableAction 
    ) {
        //Regras para entidade ComunicacaoEmail passadas dentro do construtor 
        //Injetadas pelo Spring com a anotação @Autowired    
           
        /* Criando uma lista para conter as regras de negocio de ComunicacaoEmail
         * quando a operacao for salvar
         */
        List<IStrategy> rnsSalvarComunicacaoEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do ComunicacaoEmail */
        rnsSalvarComunicacaoEmail.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de ComunicacaoEmail
         * quando a operacao for alterar
         */
        List<IStrategy> rnsAlterarComunicacaoEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do ComunicacaoEmail */
        rnsAlterarComunicacaoEmail.add(disableAction);


        /* Criando uma lista para conter as regras de negocio de ComunicacaoEmail
         * quando a operacao for alterar
         */
        List<IStrategy> rnsConsultarComunicacaoEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao consultar do ComunicacaoEmail */
        rnsConsultarComunicacaoEmail.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de ComunicacaoEmail
         * quando a operacao for excluir
         */
        List<IStrategy> rnsExcluirComunicacaoEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao excluir do ComunicacaoEmail */
        rnsExcluirComunicacaoEmail.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de ComunicacaoEmail
         * quando a operacao for visualizar
         */
        List<IStrategy> rnsVisualizarComunicacaoEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao visualizar do ComunicacaoEmail */
        rnsVisualizarComunicacaoEmail.add(disableAction);
        
        /* Criando uma lista para conter as regras de negocio de ComunicacaoEmail
         * quando a operacao for desativar
         */
        List<IStrategy> rnsDesativarComunicacaoEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao desativar do ComunicacaoEmail */
        rnsDesativarComunicacaoEmail.add(disableAction);

        /*
         * Adiciona a listra de regras na operacao salvar no mapa do ComunicacaoEmail 
         */
        rnsComunicacaoEmail.put("SALVAR", rnsSalvarComunicacaoEmail);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do ComunicacaoEmail 
         */
        rnsComunicacaoEmail.put("ALTERAR", rnsAlterarComunicacaoEmail);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do ComunicacaoEmail 
         */
        rnsComunicacaoEmail.put("CONSULTAR", rnsConsultarComunicacaoEmail);
        /*
         * Adiciona a listra de regras na operacao excluir no mapa do ComunicacaoEmail 
         */
        rnsComunicacaoEmail.put("EXCLUIR", rnsExcluirComunicacaoEmail);
        /*
         * Adiciona a listra de regras na operacao desativar no mapa do ComunicacaoEmail 
         */
        rnsComunicacaoEmail.put("DESATIVAR", rnsDesativarComunicacaoEmail);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do ComunicacaoEmail 
         */
        rnsComunicacaoEmail.put("VISUALIZAR", rnsVisualizarComunicacaoEmail);

    }

    /**
     * Retorna regras da entidade.
     * @return Map String, List -> IStrategy
     */
    public Map<String, List<IStrategy>> getRnsComunicacaoEmail() {
        return rnsComunicacaoEmail;
    }
}
