
package com.proj.wsf.view;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 *
 * @brief Classe ProjWsfViewApplicationTest
 * Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date   24/01/2019
 * @version     %I%, %G%
 * @since       1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjWsfViewApplicationTest {
    
    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Bem vindo(a) ao WebServiceFoz")));
    }
}