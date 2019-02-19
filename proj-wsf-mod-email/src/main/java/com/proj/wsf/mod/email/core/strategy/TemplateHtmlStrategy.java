/*
 * TemplateHtmlStrategy.java
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
 * Description the class  TemplateHtmlStrategy - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Component("templateHtmlStrategy")
public class TemplateHtmlStrategy {
    Map<String, List<IStrategy>> rnsTemplateHtml = new HashMap<>();

    /**
     * Contrutor da classe para inicializar as strategys.
      * @param disableAction - Strategy que desabilita a operação.
     */
    public TemplateHtmlStrategy(DisableAction disableAction 
    ) {
        //Regras para entidade TemplateHtml passadas dentro do construtor 
        //Injetadas pelo Spring com a anotação @Autowired    
           
        /* Criando uma lista para conter as regras de negocio de TemplateHtml
         * quando a operacao for salvar
         */
        List<IStrategy> rnsSalvarTemplateHtml = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do TemplateHtml */
        rnsSalvarTemplateHtml.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de TemplateHtml
         * quando a operacao for alterar
         */
        List<IStrategy> rnsAlterarTemplateHtml = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do TemplateHtml */
        rnsAlterarTemplateHtml.add(disableAction);


        /* Criando uma lista para conter as regras de negocio de TemplateHtml
         * quando a operacao for alterar
         */
        List<IStrategy> rnsConsultarTemplateHtml = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao consultar do TemplateHtml */
        rnsConsultarTemplateHtml.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de TemplateHtml
         * quando a operacao for excluir
         */
        List<IStrategy> rnsExcluirTemplateHtml = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao excluir do TemplateHtml */
        rnsExcluirTemplateHtml.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de TemplateHtml
         * quando a operacao for visualizar
         */
        List<IStrategy> rnsVisualizarTemplateHtml = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao visualizar do TemplateHtml */
        rnsVisualizarTemplateHtml.add(disableAction);
        
        /* Criando uma lista para conter as regras de negocio de TemplateHtml
         * quando a operacao for desativar
         */
        List<IStrategy> rnsDesativarTemplateHtml = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao desativar do TemplateHtml */
        rnsDesativarTemplateHtml.add(disableAction);

        /*
         * Adiciona a listra de regras na operacao salvar no mapa do TemplateHtml 
         */
        rnsTemplateHtml.put("SALVAR", rnsSalvarTemplateHtml);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do TemplateHtml 
         */
        rnsTemplateHtml.put("ALTERAR", rnsAlterarTemplateHtml);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do TemplateHtml 
         */
        rnsTemplateHtml.put("CONSULTAR", rnsConsultarTemplateHtml);
        /*
         * Adiciona a listra de regras na operacao excluir no mapa do TemplateHtml 
         */
        rnsTemplateHtml.put("EXCLUIR", rnsExcluirTemplateHtml);
        /*
         * Adiciona a listra de regras na operacao desativar no mapa do TemplateHtml 
         */
        rnsTemplateHtml.put("DESATIVAR", rnsDesativarTemplateHtml);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do TemplateHtml 
         */
        rnsTemplateHtml.put("VISUALIZAR", rnsVisualizarTemplateHtml);

    }

    /**
     * Retorna regras da entidade.
     * @return Map String, List -> IStrategy
     */
    public Map<String, List<IStrategy>> getRnsTemplateHtml() {
        return rnsTemplateHtml;
    }
}
