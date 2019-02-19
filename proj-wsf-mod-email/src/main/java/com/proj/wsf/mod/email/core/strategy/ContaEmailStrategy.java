/*
 * ContaEmailStrategy.java
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
 * Description the class  ContaEmailStrategy - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Component("contaEmailStrategy")
public class ContaEmailStrategy  {
    Map<String, List<IStrategy>> rnsContaEmail = new HashMap<>();

    /**
     * Contrutor da classe para inicializar as strategys.
      * @param disableAction - Strategy que desabilita a operação.
     */
    public ContaEmailStrategy(DisableAction disableAction 
    ) {
        //Regras para entidade ContaEmail passadas dentro do construtor 
        //Injetadas pelo Spring com a anotação @Autowired    
           
        /* Criando uma lista para conter as regras de negocio de ContaEmail
         * quando a operacao for salvar
         */
        List<IStrategy> rnsSalvarContaEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do ContaEmail */
        rnsSalvarContaEmail.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de ContaEmail
         * quando a operacao for alterar
         */
        List<IStrategy> rnsAlterarContaEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do ContaEmail */
        rnsAlterarContaEmail.add(disableAction);


        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for alterar
         */
        List<IStrategy> rnsConsultarContaEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao consultar do ContaEmail */
        rnsConsultarContaEmail.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for excluir
         */
        List<IStrategy> rnsExcluirContaEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao excluir do ContaEmail */
        rnsExcluirContaEmail.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for visualizar
         */
        List<IStrategy> rnsVisualizarContaEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao visualizar do ContaEmail */
        rnsVisualizarContaEmail.add(disableAction);
        
        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for desativar
         */
        List<IStrategy> rnsDesativarContaEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao desativar do ContaEmail */
        rnsDesativarContaEmail.add(disableAction);

        /*
         * Adiciona a listra de regras na operacao salvar no mapa do ContaEmail 
         */
        rnsContaEmail.put("SALVAR", rnsSalvarContaEmail);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do ContaEmail 
         */
        rnsContaEmail.put("ALTERAR", rnsAlterarContaEmail);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do ContaEmail 
         */
        rnsContaEmail.put("CONSULTAR", rnsConsultarContaEmail);
        /*
         * Adiciona a listra de regras na operacao excluir no mapa do ContaEmail 
         */
        rnsContaEmail.put("EXCLUIR", rnsExcluirContaEmail);
        /*
         * Adiciona a listra de regras na operacao desativar no mapa do ContaEmail 
         */
        rnsContaEmail.put("DESATIVAR", rnsDesativarContaEmail);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do ContaEmail 
         */
        rnsContaEmail.put("VISUALIZAR", rnsVisualizarContaEmail);

    }

    /**
     * Retorna regras da entidade.
     * @return Map String, List -> IStrategy
     */
    public Map<String, List<IStrategy>> getRnsContaEmail() {
        return rnsContaEmail;
    }
}
