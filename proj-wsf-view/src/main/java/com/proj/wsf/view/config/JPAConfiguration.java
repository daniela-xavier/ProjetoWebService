/*
 * JPAConfiguration.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.view.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Description the class JPAConfiguration - Classe de configurção da entidade
 * de persistencia do sistema.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 23/01/2019
 */
@Configuration
@EnableTransactionManagement
public class JPAConfiguration {
    
    private static final Logger logger = LogManager.getLogger(JPAConfiguration.class);

    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    @Value("${spring.datasource.bd.port}")
    private String springDatasourcePort;

    @Value("${spring.datasource.bd.sid}")
    private String springDatasourceSid;

    @Value("${spring.datasource.driver-class-name}")
    private String springDatasourceDriverClassName;

    @Value("${spring.datasource.username}")
    private String springDatasourceUsername;

    @Value("${spring.datasource.password}")
    private String springDatasourcePassword;

    /**
     * M�todo de instancia de fabrica da entidade de gerenciamento de conex�es.
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

        //factoryBean.setJpaProperties(aditionalProperties());
        factoryBean.setPackagesToScan("com.proj.wsf");

        return factoryBean;

    }

    /**
     * Método que adiciona propriedades para a gestão de conexão.
     *
     * @return Properties
     */
    private Properties aditionalProperties() {
       
        
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
       // properties.setProperty("hibernate.use_sql_comments", "true");
        properties.setProperty("user", springDatasourceUsername);
        properties.setProperty("password", springDatasourcePassword);
      //  properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        properties.setProperty("serverTimezone", "UTC");

        return properties;
    }

    /**
     * Método que adiciona propriedades para a conexão com o banco, Profile
     * Desenvolvimento.
     *
     * @return DataSource
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {

        ComboPooledDataSource connectionPoolDatasource = new ComboPooledDataSource();

        connectionPoolDatasource.setJdbcUrl(springDatasourceUrl + ":" + springDatasourcePort + ":" + springDatasourceSid);

        connectionPoolDatasource.setMinPoolSize(1);
        connectionPoolDatasource.setAcquireIncrement(1);
        connectionPoolDatasource.setMaxPoolSize(10);
        connectionPoolDatasource.setTestConnectionOnCheckin(true);
        connectionPoolDatasource.setTestConnectionOnCheckout(true);
        connectionPoolDatasource.setProperties(aditionalProperties());
        return connectionPoolDatasource;
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
