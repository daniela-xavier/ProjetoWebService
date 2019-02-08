package com.proj.wsf.view;

import com.proj.wsf.view.filter.RequestResponseLoggingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

/**
 *
 * @author daniela.conceicao
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.proj.wsf", "com.proj.wsf.mod"})
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class, SecurityAutoConfiguration.class})
public class ProjWsfViewApplication {

    private static ConfigurableApplicationContext context;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Spring Boot iniciando");
        SpringApplication application = new SpringApplication(ProjWsfViewApplication.class);
        ConfigurableEnvironment environment = new StandardEnvironment();
        environment.setDefaultProfiles("dev");
        environment.setActiveProfiles("dev");
        application.setAdditionalProfiles("dev");
        application.setEnvironment(environment);
        context = application.run(args);
    }

    @Value("${server.servlet.contextPath}")
    private String path;

    @Value("${server.port}")
    private String port;

    /**
     *
     * @param ctx
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("WebServiceFoz concluido");
            System.out.println("http://localhost:" + port + path);
        };
    }

    /**
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestResponseLoggingFilter());
        ///registrationBean.setFilter(new AuthenticFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }

    /**
     * Método para reiniciar o sistema
     */
    public static void restart() {
        //context.refresh();
        //Codigo para reiniciar o sistema
    }

    /**
     * Método para desligar o sistema
     */
    public static void shutdown() {
        //context.close();
         //Codigo para desligar o sistema
    }
}
