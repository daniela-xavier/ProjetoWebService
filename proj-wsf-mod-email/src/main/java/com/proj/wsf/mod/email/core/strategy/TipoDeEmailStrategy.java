/*
 * TipoDeEmailStrategy.java
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
 * Description the class  TipoDeEmailStrategy - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 19/02/2019
 */
@Component("TipoDeEmailStrategy")
public class TipoDeEmailStrategy {
    Map<String, List<IStrategy>> rnsTipoDeEmail = new HashMap<>();

    /**
     * Contrutor da classe para inicializar as strategys.
      * @param disableAction - Strategy que desabilita a operação.
     */
    public TipoDeEmailStrategy(DisableAction disableAction 
    ) {
        //Regras para entidade TipoDeEmail passadas dentro do construtor 
        //Injetadas pelo Spring com a anotação @Autowired    
           
        /* Criando uma lista para conter as regras de negocio de TipoDeEmail
         * quando a operacao for salvar
         */
        List<IStrategy> rnsSalvarTipoDeEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do TipoDeEmail */
        rnsSalvarTipoDeEmail.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de TipoDeEmail
         * quando a operacao for alterar
         */
        List<IStrategy> rnsAlterarTipoDeEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do TipoDeEmail */
        rnsAlterarTipoDeEmail.add(disableAction);


        /* Criando uma lista para conter as regras de negocio de TipoDeEmail
         * quando a operacao for alterar
         */
        List<IStrategy> rnsConsultarTipoDeEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao consultar do TipoDeEmail */
        rnsConsultarTipoDeEmail.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de TipoDeEmail
         * quando a operacao for excluir
         */
        List<IStrategy> rnsExcluirTipoDeEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao excluir do TipoDeEmail */
        rnsExcluirTipoDeEmail.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de TipoDeEmail
         * quando a operacao for visualizar
         */
        List<IStrategy> rnsVisualizarTipoDeEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao visualizar do TipoDeEmail */
        rnsVisualizarTipoDeEmail.add(disableAction);
        
        /* Criando uma lista para conter as regras de negocio de TipoDeEmail
         * quando a operacao for desativar
         */
        List<IStrategy> rnsDesativarTipoDeEmail = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao desativar do TipoDeEmail */
        rnsDesativarTipoDeEmail.add(disableAction);

        /*
         * Adiciona a listra de regras na operacao salvar no mapa do TipoDeEmail 
         */
        rnsTipoDeEmail.put("SALVAR", rnsSalvarTipoDeEmail);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do TipoDeEmail 
         */
        rnsTipoDeEmail.put("ALTERAR", rnsAlterarTipoDeEmail);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do TipoDeEmail 
         */
        rnsTipoDeEmail.put("CONSULTAR", rnsConsultarTipoDeEmail);
        /*
         * Adiciona a listra de regras na operacao excluir no mapa do TipoDeEmail 
         */
        rnsTipoDeEmail.put("EXCLUIR", rnsExcluirTipoDeEmail);
        /*
         * Adiciona a listra de regras na operacao desativar no mapa do TipoDeEmail 
         */
        rnsTipoDeEmail.put("DESATIVAR", rnsDesativarTipoDeEmail);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do TipoDeEmail 
         */
        rnsTipoDeEmail.put("VISUALIZAR", rnsVisualizarTipoDeEmail);

    }

    /**
     * Retorna regras da entidade.
     * @return Map String, List -> IStrategy
     */
    public Map<String, List<IStrategy>> getRnsTipoDeEmail() {
        return rnsTipoDeEmail;
    }
}
