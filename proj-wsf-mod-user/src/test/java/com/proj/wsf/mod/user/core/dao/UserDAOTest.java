package com.proj.wsf.mod.user.core.dao;

import com.proj.wsf.core.test.IDAOTest;
import com.proj.wsf.mod.user.model.Profile;
import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.mod.user.model.UserProfile;
import com.proj.wsf.view.config.JPAConfiguration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @brief Classe UserDAOTest Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date 31/01/2019
 * @version %I%, %G%
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAConfiguration.class)
@ContextConfiguration(classes = {UserDAO.class, User.class})
@ActiveProfiles("dev")
public class UserDAOTest implements IDAOTest {
    
    private static final Logger logger = LogManager.getLogger(UserDAOTest.class);
    
    @Autowired
    @Qualifier(value = "userDAO")
    private UserDAO userDAO;

    /**
     * Thrown ExpectedException role.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Override
    @Transactional
    public void testSave() {
        User u = new User();
        u.setEmail("teste@fozadvogados.com.br");
        u.setUsuario("teste.teste");
        u.setTk("token");
        u.setChangedIn(Calendar.getInstance().getTime());
        System.out.println(u.getChangedIn());
        this.userDAO.save(u);
        Assertions.assertThat(u.getIdentifier()).isNotNull();
    }

    @Test
    @Override
    @Transactional
    public void testFindAll() {
        for (int i = 100; i < 111; i++) {
            User u = new User();
            u.setEmail("teste" + i + "@fozadvogados.com.br");
            u.setUsuario("teste" + i + ".teste" + i);
            u.setActive("s");
            u.setTk("token");
            this.userDAO.save(u);
        }

        List<User> f = this.userDAO.findAll();
        Assertions.assertThat(f.size()).isNotEqualTo(0);
        Assertions.assertThat(f.size()).isNotNull();
    }

    @Test
    @Override
    @Transactional
    public void testUpdate() {
        User u = new User();
        u.setEmail("teste2@fozadvogados.com.br");
        u.setUsuario("teste2.teste2");
        this.userDAO.save(u);
        Assertions.assertThat(u.getIdentifier()).isNotNull();

        u.setEmail("teste2@teste.com.br");
        u.setObservacao("observacao");
        this.userDAO.update(u);

        User u2 = this.userDAO.findOne(u.getIdentifier());
        Assertions.assertThat(u2.getIdentifier()).isNotNull();
        Assertions.assertThat(u2.getUsuario()).isNotNull();
        Assertions.assertThat(u2.getEmail()).isNotNull();
        Assertions.assertThat(u2.getObservacao()).isNotNull();

    }

    @Test
    @Override
    @Transactional
    public void testDelete() {
        User u = new User();
        u.setEmail("teste3@fozadvogados.com.br");
        u.setUsuario("teste3.teste3");
        u.setActive("s");
        this.userDAO.save(u);
        Assertions.assertThat(u.getIdentifier()).isNotNull();

        this.userDAO.delete(u);

        User u2 = this.userDAO.findOne(u.getIdentifier());
        Assertions.assertThat(u2.getActive()).isEqualTo("n");

    }

    @Test
    @Override
    @Transactional
    public void testDeleteById() {
        User u = new User();
        u.setEmail("teste4@fozadvogados.com.br");
        u.setUsuario("teste4.teste4");
        this.userDAO.save(u);
        Assertions.assertThat(u.getIdentifier()).isNotNull();

        this.userDAO.deleteById(u.getIdentifier());

        User u4 = this.userDAO.findOne(u.getIdentifier());
        Assertions.assertThat(u4).isNull();
    }

    @Test
    @Override
    @Transactional
    public void testFindOne() {
        User u = new User();
        u.setEmail("teste5@fozadvogados.com.br");

        this.userDAO.save(u);
        Assertions.assertThat(u.getIdentifier()).isNotNull();

        User u4 = this.userDAO.findOne(u.getIdentifier());
        Assertions.assertThat(u4).isNotNull();
        Assertions.assertThat(u4.getEmail()).isNotNull();
        Assertions.assertThat(u4).isEqualTo(u);
    }

    @Test
    @Override
    @Transactional
    public void testFindByCriteria() {
        User u = new User();
        u.setEmail("teste6@fozadvogados.com.br");
        u.setUsuario("teste6.teste6");
        u.setActive("S");
        u.setObservacao("observacao do usuario");
        u.setTk("token");
        this.userDAO.save(u);

        User u2 = new User();
        u2.setObservacao("observacao do usuario");
        List<User> findByCriteria = this.userDAO.findByCriteria(u2);
        Assertions.assertThat(findByCriteria.size()).isEqualTo(1);

    }
    
    /**
     * Teste de busca por critérios com collection.
     */
    @Test
    @Transactional
    public void testFindByCriteriaCollection() {
        User u = new User();
        u.setIdentifier(Long.parseLong("1")); 
        List<User> findByCriteria = this.userDAO.findByCriteria(u);
        User user = findByCriteria.get(0);
        Assertions.assertThat(user.getSearchNameProfile(new Profile("Perfil teste"))).isNotNull();
        List<UserProfile> userProfiles = new ArrayList(user.getUserProfile());
        Assertions.assertThat(userProfiles.size()).isEqualTo(1);
        Assertions.assertThat(user.getFirstUserProfile().getProfile().getNome()).isEqualTo("Perfil teste");

    }
    
   /**
     * Teste de busca por critérios.
     */
    @Test
    @Transactional
    public void testFindByCriteriaProfile() {
        User u = new User();
        u.addProfileCollectionUserProfile(new Profile("Perfil teste"));
        List<User> findByCriteria = this.userDAO.findByCriteria(u);
        User user = findByCriteria.get(0);
        Assertions.assertThat(user.getUserProfile()).isNotNull();
        Assertions.assertThat(user.getUserProfile().size()).isEqualTo(1);
        Assertions.assertThat(user.getFirstUserProfile().getProfile().getNome()).isEqualTo("Perfil teste");
        Assertions.assertThat(user.getFirstUserProfile().getProfile().getDescricao()).isEqualTo("perfil para teste");

    }
    
    /**
     * Teste de busca por critérios.
     */
    @Test
    @Transactional
    public void testFindByCriteriaOtherProfile() {
        User u = new User();
        u.setIdentifier(Long.parseLong("1"));
        Profile p = new Profile();
        //p.setId(Long.parseLong("2"));
        p.setNome("Perfil teste 2");
        u.addProfileCollectionUserProfile(p);
        List<User> findByCriteria = this.userDAO.findByCriteria(u);
        Assertions.assertThat(findByCriteria.size()).isEqualTo(0);
    }

}
