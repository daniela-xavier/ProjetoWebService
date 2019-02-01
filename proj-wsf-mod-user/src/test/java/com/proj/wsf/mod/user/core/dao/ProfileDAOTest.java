
package com.proj.wsf.mod.user.core.dao;

import com.proj.wsf.core.test.IDAOTest;
import com.proj.wsf.mod.user.model.PermissionProfile;
import com.proj.wsf.mod.user.model.Profile;
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
 * @brief Classe ProfileDAOTest
 * Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date   31/01/2019
 * @version     %I%, %G%
 * @since       1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAConfiguration.class)
@ContextConfiguration(classes = {ProfileDAO.class, Profile.class})
@ActiveProfiles("dev")
public class ProfileDAOTest implements IDAOTest {

    @Autowired
    @Qualifier(value = "perfilDAO")
    private ProfileDAO profileDAO;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Override
    @Transactional
    public void testSave() {
        Profile u = new Profile();
        u.setNome("Perfil X");
        u.setDescricao("Descricao do perfil X");
        this.profileDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();
    }

    @Test
    @Override
    @Transactional
    public void testFindAll() {
        for (int i = 100; i < 111; i++) {
            Profile u = new Profile();
            u.setNome("Perfil "+i);
            u.setDescricao("Descricao do perfil Nº "+i);
            u.setActive("s");
            this.profileDAO.save(u);
        }

        List<Profile> f = this.profileDAO.findAll();
        Assertions.assertThat(f.size()).isNotEqualTo(0);
        Assertions.assertThat(f.size()).isNotNull();
    }

    @Test
    @Override
    @Transactional
    public void testUpdate() {
        Profile u = new Profile();
        u.setNome("PERFIL Z");
        u.setDescricao("Descricao do perfil Z");
        this.profileDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();

        u.setNome("PERFIL Z");
        this.profileDAO.update(u);

        Profile u2 = this.profileDAO.findOne(u.getId());
        Assertions.assertThat(u2.getId()).isNotNull();
        Assertions.assertThat(u2.getNome()).isNotNull();
        Assertions.assertThat(u2.getDescricao()).isNotNull();

    }

    @Test
    @Override
    @Transactional
    public void testDelete() {
        Profile u = new Profile();
        u.setNome("Perfil Y");
        u.setDescricao("Descricao do perfil Y");
        this.profileDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();

        this.profileDAO.delete(u);

        Profile u2 = this.profileDAO.findOne(u.getId());
        Assertions.assertThat(u2).isNull();

    }

    @Test
    @Override
    @Transactional
    public void testDeleteById() {
        Profile u = new Profile();
        u.setNome("Perfil A");
        this.profileDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();

        this.profileDAO.deleteById(u.getId());

        Profile u4 = this.profileDAO.findOne(u.getId());
        Assertions.assertThat(u4).isNull();
    }

    @Test
    @Override
    @Transactional
    public void testFindOne() {
        Profile u = new Profile();
        u.setNome("Perfil B");

        this.profileDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();

        Profile u4 = this.profileDAO.findOne(u.getId());
        Assertions.assertThat(u4).isNotNull();
        Assertions.assertThat(u4.getNome()).isNotNull();
        Assertions.assertThat(u4).isEqualTo(u);
    }

    @Test
    @Override
    @Transactional
    public void testFindByCriteria() {
        Profile p = new Profile();
        p.setNome("Perfil C");
        p.setDescricao("Descricao do perfil CCC");
        p.setActive("S");
        this.profileDAO.save(p);
       

        Profile u2 = new Profile();
        u2.setDescricao("%CCC%");
        List<Profile> findByCriteria = this.profileDAO.findByCriteria(u2);    
        Assertions.assertThat(findByCriteria.size()).isEqualTo(1);
        Assertions.assertThat(findByCriteria.get(0).getDescricao()).isEqualTo("Descricao do perfil CCC");

    }
    
     
    @Test
    @Transactional
    public void testFindByCriteriaCollection() {
        Profile u = new Profile();
        u.setId(Long.parseLong("1")); 
        List<Profile> findByCriteria = this.profileDAO.findByCriteria(u);
        Assertions.assertThat(findByCriteria.get(0).getPermissionProfile().size()).isEqualTo(1);
        List<PermissionProfile> permissions = new ArrayList(findByCriteria.get(0).getPermissionProfile());
        Assertions.assertThat(permissions.get(0).getActive()).isEqualTo("s");

    }
   

}
