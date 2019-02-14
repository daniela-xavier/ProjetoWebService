package com.proj.wsf.view.controller;

import com.proj.wsf.view.AppWsf;
import com.proj.wsf.view.config.JPAConfiguration;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @brief Classe IndexControllerTest Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date 07/02/2019
 * @version %I%, %G%
 * @since 1.0
 */

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = JPAConfiguration.class)
@ContextConfiguration(classes = {JPAConfiguration.class, AppWsf.class})
@ActiveProfiles("dev")
public class IndexControllerTest {

   
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    /**
     *
     * @throws Exception
     */
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void getHello() throws Exception {
          this.mockMvc.perform(MockMvcRequestBuilders.get("/foz")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Bem vindo(a) ao WebServiceFoz"
                + "\t Documentação do projeto: " + "http://localhost:1221/WebServiceFozDev/swagger-ui.html")));
    }
    
    

}
