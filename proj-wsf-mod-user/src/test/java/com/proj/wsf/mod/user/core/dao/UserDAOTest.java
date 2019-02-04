package com.proj.wsf.mod.user.core.dao;

import com.proj.wsf.core.test.IDAOTest;
import com.proj.wsf.mod.user.model.Profile;
import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.mod.user.model.UserProfile;
import com.proj.wsf.view.config.JPAConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.Rule;
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

    @Autowired
    @Qualifier(value = "usuarioDAO")
    private UserDAO usuarioDAO;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Override
    @Transactional
    public void testSave() {
        User u = new User();
        u.setEmail("teste@fozadvogados.com.br");
        u.setUsuario("teste.teste");
        u.setToken("token");
        this.usuarioDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();
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
            u.setToken("token");
            this.usuarioDAO.save(u);
        }

        List<User> f = this.usuarioDAO.findAll();
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
        this.usuarioDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();

        u.setEmail("teste2@teste.com.br");
        u.setObservacao("observacao");
        this.usuarioDAO.update(u);

        User u2 = this.usuarioDAO.findOne(u.getId());
        Assertions.assertThat(u2.getId()).isNotNull();
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
        this.usuarioDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();

        this.usuarioDAO.delete(u);

        User u2 = this.usuarioDAO.findOne(u.getId());
        Assertions.assertThat(u2).isNull();

    }

    @Test
    @Override
    @Transactional
    public void testDeleteById() {
        User u = new User();
        u.setEmail("teste4@fozadvogados.com.br");
        u.setUsuario("teste4.teste4");
        this.usuarioDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();

        this.usuarioDAO.deleteById(u.getId());

        User u4 = this.usuarioDAO.findOne(u.getId());
        Assertions.assertThat(u4).isNull();
    }

    @Test
    @Override
    @Transactional
    public void testFindOne() {
        User u = new User();
        u.setEmail("teste5@fozadvogados.com.br");

        this.usuarioDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();

        User u4 = this.usuarioDAO.findOne(u.getId());
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
        u.setToken("token");
        this.usuarioDAO.save(u);

        User u2 = new User();
        u2.setObservacao("observacao do usuario");
        List<User> findByCriteria = this.usuarioDAO.findByCriteria(u2);
        Assertions.assertThat(findByCriteria.size()).isEqualTo(1);

    }
    
    @Test
    @Transactional
    public void testFindByCriteriaCollection() {
        User u = new User();
        u.setId(Long.parseLong("1")); 
        List<User> findByCriteria = this.usuarioDAO.findByCriteria(u);
        User user = findByCriteria.get(0);
        Assertions.assertThat(user.getSearchNameProfile(new Profile("Perfil teste"))).isNotNull();
        List<UserProfile> userProfiles = new ArrayList(user.getUserProfile());
        Assertions.assertThat(userProfiles.size()).isEqualTo(1);
        Assertions.assertThat(user.getFirstUserProfile().getProfile().getNome()).isEqualTo("Perfil teste");

    }
    
    @Test
    @Transactional
    public void testFindByCriteriaProfile() {
        User u = new User();
        u.addProfileCollectionUserProfile(new Profile("Perfil teste"));
        List<User> findByCriteria = this.usuarioDAO.findByCriteria(u);
        User user = findByCriteria.get(0);
        Assertions.assertThat(user.getUserProfile()).isNotNull();
        Assertions.assertThat(user.getUserProfile().size()).isEqualTo(1);
        Assertions.assertThat(user.getFirstUserProfile().getProfile().getNome()).isEqualTo("Perfil teste");
        Assertions.assertThat(user.getFirstUserProfile().getProfile().getDescricao()).isEqualTo("perfil para teste");

    }
    
    @Test
    @Transactional
    public void testFindByCriteriaOtherProfile() {
        User u = new User();
        u.addProfileCollectionUserProfile(new Profile("Perfil teste 2"));
        List<User> findByCriteria = this.usuarioDAO.findByCriteria(u);
        Assertions.assertThat(findByCriteria).isNull();
    }

}
