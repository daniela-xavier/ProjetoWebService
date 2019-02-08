
package com.proj.wsf.mod.user.core.repository;

import com.proj.wsf.core.application.Result;
import com.proj.wsf.core.test.IRepositoryTest;
import com.proj.wsf.mod.user.core.dao.ProfileDAO;
import com.proj.wsf.mod.user.model.Profile;
import com.proj.wsf.model.DomainEntity;
import com.proj.wsf.view.config.JPAConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @brief Classe ProfileRepositoryTest
 * Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date   05/02/2019
 * @version     %I%, %G%
 * @since       1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAConfiguration.class)
@ContextConfiguration(classes = { JPAConfiguration.class, ProfileDAO.class, Profile.class, ProfileRepository.class})
@ActiveProfiles("dev")
public class ProfileRepositoryTest  implements IRepositoryTest {

    @Autowired
    ProfileRepository uR;

    @Test
    @Override
    @Transactional
    public void save() {
        Result resultado = new Result();
        Profile entidade = new Profile();
        entidade.setNome("Perfil XXX");
        entidade.setDescricao("descricao do perfil xxxx");
        entidade.setActive("S");
        try {
            uR.save(entidade);
            List<DomainEntity> entidades = new ArrayList<DomainEntity>();
            entidades.add(entidade);
            resultado.setEntity(entidades);
        } catch (Exception e) {
            resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
        }

        Assertions.assertThat(resultado.getEntity()).isNotNull();
    }

    @Test
    @Override
    @Transactional
    public void update() {
        Result resultado = new Result();
        Profile entidade = new Profile();
        entidade.setNome("Perfil XXX");
        entidade.setActive("S");
        uR.save(entidade);

        try {
            entidade.setDescricao("observação");
            uR.update(entidade);

            Profile u = new Profile();
            u.setDescricao("observação");
            
            List<DomainEntity> entidades = uR.findByFilter(u);
            resultado.setEntity(entidades);
            
        } catch (Exception e) {
            resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
        }

        Assertions.assertThat(resultado.getEntity()).isNotNull();

    }

    @Test
    @Override
    @Transactional
    public void delete() {
        Result resultado = new Result();
        Profile entidade = new Profile();
        entidade.setNome("Perfil ZZZ");
        entidade.setDescricao("descricao do perfil zzzz");
        entidade.setActive("S");
        uR.save(entidade);

        try {
            uR.delete(entidade.getIdentifier());

            Profile u = new Profile();
            u.setNome("Perfil ZZZ");

            List<DomainEntity> entidades = uR.findByFilter(u);
            resultado.setEntity(entidades);
        } catch (Exception e) {
            resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
        }
     
        Assertions.assertThat(((Collection<?>) resultado.getEntity()).size()).isEqualTo(0);
    }

    @Test
    @Override
    @Transactional
    public void findByFilter() {
        Result resultado = new Result();

        Profile entidade = new Profile();
        entidade.setNome("Perfil YXW");
        entidade.setDescricao("descricao XYW");
        entidade.setActive("S");
        uR.save(entidade);

        try {
            List<DomainEntity> entidades = uR.findByFilter(entidade);
            resultado.setEntity(entidades);
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString() + " Message: " + e.getMessage());
        }

        Assertions.assertThat(resultado.getEntity()).isNotNull();
    }

    @Test
    @Override
    @Transactional
    public void findAll() {
        Result resultado = new Result();

        try {
            List<DomainEntity> entidades = uR.findAll();
            resultado.setEntity(entidades);
        } catch (Exception e) {
            resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
        }

        Assertions.assertThat(resultado.getEntity()).isNotNull();
    }

    @Test
    @Override
    @Transactional
    public void findById() {
         Result resultado = new Result();

        Profile entidade = new Profile();
        entidade.setNome("Perfil YYYY");
        entidade.setDescricao("Descricao do perfil YYYY");
        entidade.setActive("S");
        uR.save(entidade);

        try {
            List<DomainEntity> entidades = uR.findById(entidade.getIdentifier());
            resultado.setEntity(entidades);
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString() + " Message: " + e.getMessage());
        }

        Assertions.assertThat(resultado.getEntity()).isNotNull();
    }

}
