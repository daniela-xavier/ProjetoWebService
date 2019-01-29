package com.proj.wsf.view;

import com.proj.wsf.view.filter.RequestResponseLoggingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
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

@SpringBootApplication
@ComponentScan("com.proj.wsf")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class, SecurityAutoConfiguration.class})
public class ProjWsfViewApplication {

    private static ConfigurableApplicationContext context;

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

    @Value( "${server.servlet.contextPath}" )
    private String path;    
    
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        
            
            System.out.println("WebServiceFoz concluido");
            System.out.println("http://localhost:1221"+path);
        };
    }

    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestResponseLoggingFilter());
        ///registrationBean.setFilter(new AuthenticFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }

    public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);

        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(ProjWsfViewApplication.class, args.getSourceArgs());
        });

        thread.setDaemon(false);
        thread.start();
    }

}
