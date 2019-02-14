package com.proj.wsf.mod.user.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proj.wsf.core.test.AbstractControllerTest;
import com.proj.wsf.core.test.IControllerTest;
import com.proj.wsf.core.util.DateDeserializer;
import com.proj.wsf.core.util.DateSerializer;
import com.proj.wsf.mod.user.core.dao.UserDAO;
import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.view.AppWsf;
import com.proj.wsf.view.config.JPAConfiguration;
import com.proj.wsf.view.filter.AuthenticFilter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @brief Classe UserControllerIT Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date 07/02/2019
 * @version %I%, %G%
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration(value = "")
@SpringBootTest(classes = AppWsf.class)
@ContextConfiguration(classes = {AppWsf.class, JPAConfiguration.class})
@ActiveProfiles("dev")
public class UserControllerIT extends AbstractControllerTest implements IControllerTest {

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    private UserDAO userDAO;

    private Long idUserSave = null;
    private Long idUserUpdate = null;

    @Autowired
    AuthenticFilter authenticFilter;

    /**
     * Setup do mockMvc.
     *
     * @throws Exception
     */
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(authenticFilter, "/*").build();
    }

    @Override
    public void testGetIdSucess() throws Exception {
    }

    @Test
    @Override
    public void testGetIdInsuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(CONTENT_TYPE)
                .header("Authentication", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZS50ZXN0ZSIsImF1ZCI6IlBBUkFfQUNIQVJfQV9TT0xVQ0FPX05BREFSIn0.02Ie8DmbiBwaOMFOEWC49dcT0yhHPrpwcHb_x9r5f54iP5Tend_1GCmfAT7p6oJGfd3FmDCJNnSBYnA_wsd5Wg"))
                .andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação."));
    }

    @Override
    public void testGetFilterSucess() throws Exception {
    }

    @Test
    @Override
    public void testGetFilterInsuccess() throws Exception {

        User user = new User();
        user.setIdentifier(1L);
        user.setUsuario("teste");
        Gson gson = new Gson();

        String json = gson.toJson(user);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .content(json)
                .header("Authentication", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZS50ZXN0ZSIsImF1ZCI6IlBBUkFfQUNIQVJfQV9TT0xVQ0FPX05BREFSIn0.02Ie8DmbiBwaOMFOEWC49dcT0yhHPrpwcHb_x9r5f54iP5Tend_1GCmfAT7p6oJGfd3FmDCJNnSBYnA_wsd5Wg")                 .contentType(CONTENT_TYPE)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação."));
    }

    @Test
    @Override
    public void testPostSucess() throws Exception {
        int nRand = new Random().nextInt();
        User user = new User();
        user.setUsuario("teste.teste" + nRand);
        user.setEmail("teste" + nRand + "@teste.com.br");
        user.setActive("s");
        user.setUser("teste.teste");
        user.setIncludedBy("EU");
        user.setIncludedIn(Calendar.getInstance().getTime());

        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Date.class, new DateDeserializer());
        gson.registerTypeAdapter(Date.class, new DateSerializer());

        Gson objGson = gson.setPrettyPrinting().create();
        String json = objGson.toJson(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content(json)
                .header("Authentication", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZS50ZXN0ZSIsImF1ZCI6IlBBUkFfQUNIQVJfQV9TT0xVQ0FPX05BREFSIn0.02Ie8DmbiBwaOMFOEWC49dcT0yhHPrpwcHb_x9r5f54iP5Tend_1GCmfAT7p6oJGfd3FmDCJNnSBYnA_wsd5Wg")
                .contentType(CONTENT_TYPE)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Cadastro realizado com sucesso."));

    }

    /**
     * Teste verifica cadastro em duplicidade
     *
     * @throws Exception
     */
    @Test
    @Override
    public void testPostInsuccess() throws Exception {

        User user = new User();
        user.setUsuario("teste.teste");
        user.setUser("teste.teste");
        user.setEmail("teste@teste.com.br");
        user.setActive("s");
        user.setIncludedBy("EU");
        user.setIncludedIn(Calendar.getInstance().getTime());

        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Date.class, new DateDeserializer());
        gson.registerTypeAdapter(Date.class, new DateSerializer());

        Gson objGson = gson.setPrettyPrinting().create();
        String json = objGson.toJson(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content(json)
                .header("Authentication", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZS50ZXN0ZSIsImF1ZCI6IlBBUkFfQUNIQVJfQV9TT0xVQ0FPX05BREFSIn0.02Ie8DmbiBwaOMFOEWC49dcT0yhHPrpwcHb_x9r5f54iP5Tend_1GCmfAT7p6oJGfd3FmDCJNnSBYnA_wsd5Wg")
                .contentType(CONTENT_TYPE)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("<> Usuario já consta como cadastrado."));

    }

    @Override
    public void testPutSucess() throws Exception {
        userDAO = this.wac.getBean(UserDAO.class);

        User userfinal = new User();
        userfinal.setActive("s");
        userfinal.setUsuario("teste");
        userfinal.setChangedBy("EU");
        userfinal.setChangedIn(Calendar.getInstance().getTime());
        this.userDAO.save(userfinal);
        Assertions.assertThat(userfinal.getIdentifier()).isNotNull();
        idUserUpdate = userfinal.getIdentifier();

    }

    @Test
    @Override
    public void testPutInsuccess() throws Exception {
        User user = new User();
        user.setIdentifier(idUserUpdate);
        user.setObservacao("teste de atualização");
        user.setChangedBy("EU");
        user.setChangedIn(Calendar.getInstance().getTime());

        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Date.class, new DateDeserializer());
        gson.registerTypeAdapter(Date.class, new DateSerializer());

        Gson objGson = gson.setPrettyPrinting().create();
        String json = objGson.toJson(user);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user")
                .contentType(CONTENT_TYPE)
                 .content(json)
                .header("Authentication", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZS50ZXN0ZSIsImF1ZCI6IlBBUkFfQUNIQVJfQV9TT0xVQ0FPX05BREFSIn0.02Ie8DmbiBwaOMFOEWC49dcT0yhHPrpwcHb_x9r5f54iP5Tend_1GCmfAT7p6oJGfd3FmDCJNnSBYnA_wsd5Wg")
                .content(json)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação."));

    }

    @Override
    public void testDeleteIdSucess() throws Exception {
    }

    @Test
    @Override
    public void testDeleteIdInsuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .header("Authentication", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZS50ZXN0ZSIsImF1ZCI6IlBBUkFfQUNIQVJfQV9TT0xVQ0FPX05BREFSIn0.02Ie8DmbiBwaOMFOEWC49dcT0yhHPrpwcHb_x9r5f54iP5Tend_1GCmfAT7p6oJGfd3FmDCJNnSBYnA_wsd5Wg")
                .contentType(CONTENT_TYPE))
                .andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação."));

    }

    @Override
    public void testDisableSucess() throws Exception {
    }

    @Test
    @Override
    public void testDisableInsuccess() throws Exception {
        User user = new User();
        user.setIdentifier(1L);
        user.setUsuario("teste");
        Gson gson = new Gson();

        String json = gson.toJson(user);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/user")
                .content(json)
                .header("Authentication", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZS50ZXN0ZSIsImF1ZCI6IlBBUkFfQUNIQVJfQV9TT0xVQ0FPX05BREFSIn0.02Ie8DmbiBwaOMFOEWC49dcT0yhHPrpwcHb_x9r5f54iP5Tend_1GCmfAT7p6oJGfd3FmDCJNnSBYnA_wsd5Wg")
                .contentType(CONTENT_TYPE)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação."));
    }

    @Test
    @After
    public void deleteAfter() {

        if (idUserSave != null) {
            User userSave = this.userDAO.findOne(idUserSave);
            Assertions.assertThat(userSave).isNull();
            this.userDAO.deleteById(userSave.getIdentifier());
            User u2 = this.userDAO.findOne(userSave.getIdentifier());
            Assertions.assertThat(u2).isNull();
        }

        if (idUserUpdate != null) {
            User userUpdate = this.userDAO.findOne(idUserUpdate);
            Assertions.assertThat(userUpdate).isNull();
            this.userDAO.deleteById(userUpdate.getIdentifier());
            User u3 = this.userDAO.findOne(userUpdate.getIdentifier());
            Assertions.assertThat(u3).isNull();
        }
    }

}
