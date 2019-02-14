package com.proj.wsf.view;

import com.proj.wsf.view.config.JPAConfiguration;
import javax.servlet.ServletContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @brief Classe ProjWsfViewApplicationTest Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date 24/01/2019
 * @version %I%, %G%
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppWsf.class)
@ContextConfiguration(classes = {JPAConfiguration.class, AppWsf.class})
@ActiveProfiles("dev")
public class AppWsfTest {

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
     * Teste de ambiente para beans e controller.
     */
    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        /*for (String beanDefinitionName : wac.getBeanDefinitionNames()) {
        System.out.println("Bean: " + beanDefinitionName);
        }*/
        Assert.assertNotNull(wac.getBean("domainEntityController"));
        Assert.assertNotNull(wac.getBean("disableAction"));
        Assert.assertNotNull(wac.getBean("authenticFilter"));
    }
}
