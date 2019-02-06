package com.proj.wsf.mod.user.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proj.wsf.mod.user.model.User;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 *
 * @brief Classe UserControllerTest Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date 06/02/2019
 * @version %I%, %G%
 * @since 1.0
 */
public class UserControllerTest {

    private final MockMvc mockMvc = standaloneSetup(new UserController())
            .build();

    @Autowired
    ObjectMapper objectMapper;

    //@Test
    public void validate_get_id_sucess() throws Exception {

        mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.street").value("12345 Horton Ave"));

    }

    @Test
    public void validate_get_id_fail() throws Exception {
      
        mockMvc.perform(get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )               
                .andExpect(status().is5xxServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação.\n"));

    }

}
