/*
 * JPAConfiguration.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.wsf.core.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Description the class  JPAConfiguration - Classe de configurção da entidade de
 * persistencia do sistema.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
@Configuration
@EnableTransactionManagement
public class JPAConfiguration {

    /**
     * Método de instancia de fabrica da entidade de gerenciamento de conexões.
     *
     * @param dataSource - Data source criado.
     * @return LocalContainerEntityManagerFactoryBean
     */
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setDataSource(dataSource);

        factoryBean.setJpaProperties(aditionalProperties());
        factoryBean.setPackagesToScan("com.proj.art.core");
        factoryBean.setPackagesToScan("com.proj.art.model");
        factoryBean.setPackagesToScan("com.proj.art.mod");

        return factoryBean;

    }

    /**
     * Método que adiciona propriedades para a gestão de conexão.
     *
     * @return Properties
     */
    private Properties aditionalProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        jpaProperties.setProperty("hibernate.show_sql", "true");
        jpaProperties.setProperty("hibernate.format_sql", "true");
        jpaProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        jpaProperties.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

        //Configuração do C3PO 
        jpaProperties.setProperty("hibernate.c3p0.min_size", "5");
        jpaProperties.setProperty("hibernate.c3p0.max_size", "100");
        jpaProperties.setProperty("hibernate.c3p0.acquire_increment", "1800");
        jpaProperties.setProperty("hibernate.c3p0.max_statements", "150");

        return jpaProperties;
    }

    /**
     * Método que adiciona propriedades para a conexão com o banco, Profile
     * Desenvolvimento.
     *
     * @return DataSource
     */    
    @Bean(name = "dataSource")
    @Profile("dev")
    public DataSource dataSourceDev() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@172.16.20.249:1521:FOZTST");
        dataSource.setUsername("FOZWSF");
        dataSource.setPassword("D0llar370");
        return dataSource;
    }

    /**
     * Método que adiciona propriedades para a conexão com o banco, Profile
     * Homologação.
     *
     * @return DataSource
     */    
    @Bean(name = "dataSource")
    @Profile("hml")
    public DataSource dataSourceHml() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@172.16.20.249:1521:FOZHML");
        dataSource.setUsername("FOZWSF");
        dataSource.setPassword("D0llar370");
        return dataSource;
    }

    /**
     * Método que adiciona propriedades para a conexão com o banco, Profile
     * Produção.
     *
     * @return DataSource
     */    
    @Bean(name = "dataSource")
    @Profile("prd")
    public DataSource dataSourcePrd() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@172.16.20.41:1521:FOZHML");
        dataSource.setUsername("FOZWSF");
        dataSource.setPassword("D0llar370");
        return dataSource;
    }

    /**
     * Método que recupera a transação.
     *
     * @param emf - EntityManagerFactory enviada.
     * @return JpaTransactionManager
     */
    @Bean(name = "transactionManager")
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

}
