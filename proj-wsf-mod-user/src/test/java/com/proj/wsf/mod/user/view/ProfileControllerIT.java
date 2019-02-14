package com.proj.wsf.mod.user.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proj.wsf.core.test.AbstractControllerTest;
import com.proj.wsf.core.test.IControllerTest;
import com.proj.wsf.core.util.DateDeserializer;
import com.proj.wsf.core.util.DateSerializer;
import com.proj.wsf.mod.user.model.Profile;
import com.proj.wsf.view.AppWsf;
import com.proj.wsf.view.config.JPAConfiguration;
import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
 * @brief Classe ProfileControllerIT Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date 07/02/2019
 * @version %I%, %G%
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration(value = "")
@SpringBootTest(classes = JPAConfiguration.class)
@ContextConfiguration(classes = {JPAConfiguration.class, AppWsf.class})
@ActiveProfiles("dev")
public class ProfileControllerIT extends AbstractControllerTest implements IControllerTest {

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    /**
     * Setup do mockMvc.
     * @throws Exception
     */
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Override
    public void testGetIdSucess() throws Exception {
    }

    @Test
    @Override
    public void testGetIdInsuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/profile/1")
                .contentType(CONTENT_TYPE))
                .andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação.\n"));
    }

    @Override
    public void testGetFilterSucess() throws Exception {
    }

    @Test
    @Override
    public void testGetFilterInsuccess() throws Exception {

        Profile profile = new Profile();
        profile.setIdentifier(1L);
        profile.setNome("teste");
        Gson gson = new Gson();

        String json = gson.toJson(profile);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/profile")
                .content(json)
                .contentType(CONTENT_TYPE)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação.\n"));
    }

    @Override
    public void testPostSucess() throws Exception {
    }

    @Test
    @Override
    public void testPostInsuccess() throws Exception {
        Profile profile = new Profile();
        profile.setIdentifier(1L);
        profile.setNome("teste"); 
        profile.setIncludedBy("EU");
        profile.setActive("S");
        profile.setIncludedIn(Calendar.getInstance().getTime());
        
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Date.class, new DateDeserializer());
        gson.registerTypeAdapter(Date.class, new DateSerializer());

        Gson objGson = gson.setPrettyPrinting().create();
        String json = objGson.toJson(profile);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/profile")
                .content(json)
                .contentType(CONTENT_TYPE)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação.\n"));

    }

    @Override
    public void testPutSucess() throws Exception {
    }

    @Test
    @Override
    public void testPutInsuccess() throws Exception {
        Profile profile = new Profile();
        profile.setIdentifier(1L);
        profile.setNome("teste"); 
        profile.setChangedBy("EU"); 
        profile.setActive("S");
        profile.setChangedIn(Calendar.getInstance().getTime());
        
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Date.class, new DateDeserializer());
        gson.registerTypeAdapter(Date.class, new DateSerializer());

        Gson objGson = gson.setPrettyPrinting().create();
        String json = objGson.toJson(profile);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/profile")
                .content(json)
                .contentType(CONTENT_TYPE)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação.\n"));

    }

    @Override
    public void testDeleteIdSucess() throws Exception {
    }

    @Test
    @Override
    public void testDeleteIdInsuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/profile/1")
                .contentType(CONTENT_TYPE))
                .andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação.\n"));

    }

    @Override
    public void testDisableSucess() throws Exception {
    }

    @Test
    @Override
    public void testDisableInsuccess() throws Exception {
        Profile profile = new Profile();
        profile.setIdentifier(1L);
        profile.setNome("teste");
        Gson gson = new Gson();

        String json = gson.toJson(profile);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/profile")
                .content(json)
                .contentType(CONTENT_TYPE)).andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.message").value("Processos inválido. Não é possível executar esta ação.\n"));
    }

}
