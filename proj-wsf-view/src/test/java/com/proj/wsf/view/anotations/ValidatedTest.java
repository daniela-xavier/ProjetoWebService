package com.proj.wsf.view.anotations;

import com.google.gson.Gson;
import com.proj.wsf.model.DomainEntity;
import com.proj.wsf.view.ProjWsfViewApplication;
import com.proj.wsf.view.config.JPAConfiguration;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @brief Classe PostEntityValidateTest Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date 11/02/2019
 * @version %I%, %G%
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = JPAConfiguration.class)
@ContextConfiguration(classes = {JPAConfiguration.class, ProjWsfViewApplication.class})
@ActiveProfiles("dev")
public class ValidatedTest {
    
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

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
    public void getPostValidate() throws Exception {
        DomainEntity entity = new DomainEntity();
        Gson gson = new Gson();

        String json = gson.toJson(entity);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1")
                .content(json)
                .contentType(CONTENT_TYPE)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").isString());
    }
    /**
     *
     * @throws Exception
     */
    @Test
    public void getPutValidate() throws Exception {
        DomainEntity entity = new DomainEntity();       
        Gson gson = new Gson();

        String json = gson.toJson(entity);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1")
                .content(json)
                .contentType(CONTENT_TYPE)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").isString());
    }

}
