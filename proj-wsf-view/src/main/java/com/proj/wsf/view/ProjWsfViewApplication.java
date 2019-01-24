package com.proj.wsf.view;

import com.proj.wsf.view.controller.RestartController;
import com.proj.wsf.view.filter.RequestResponseLoggingFilter;
import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
@ComponentScan("com.proj.wsf")
public class ProjWsfViewApplication {

    private static ConfigurableApplicationContext context;
    
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ProjWsfViewApplication.class);
        ConfigurableEnvironment environment = new StandardEnvironment();
        environment.setDefaultProfiles("dev");
        environment.setActiveProfiles("dev", "hml", "prd");
        application.setAdditionalProfiles("dev", "hml", "prd");
        context = application.run(args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Spring Boot iniciando");

            String[] beanNames = ctx.getBeanDefinitionNames();
            System.out.println("Loading ...");
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                //System.out.println(beanName);
            
            }          
            System.out.println("WebServiceFoz concluido");
            System.out.println("http://localhost:1221/WebServiceFoz###");
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
