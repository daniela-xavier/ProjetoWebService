
package com.proj.wsf.mod.user.core.repository;

import com.proj.wsf.core.application.Result;
import com.proj.wsf.core.test.IRepositoryTest;
import com.proj.wsf.mod.user.core.dao.UserDAO;
import com.proj.wsf.mod.user.model.User;
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
 * @brief Classe UserRepositoryTest
 * Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date   05/02/2019
 * @version     %I%, %G%
 * @since       1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAConfiguration.class)
@ContextConfiguration(classes = { JPAConfiguration.class, UserDAO.class, User.class, UserRepository.class})
@ActiveProfiles("dev")
public class UserRepositoryTest  implements IRepositoryTest {

    @Autowired
    UserRepository uR;

    @Test
    @Override
    @Transactional
    public void save() {
        Result resultado = new Result();
        User entidade = new User();
        entidade.setEmail("teste@teste.com.br");
        entidade.setUsuario("teste.teste");
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
        User entidade = new User();
        entidade.setEmail("teste@teste.com.br");
        entidade.setUsuario("teste.teste");
        entidade.setActive("S");
        uR.save(entidade);

        try {
            entidade.setObservacao("observação");
            uR.update(entidade);

            User u = new User();
            u.setObservacao("observação");
            
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
        User entidade = new User();
        entidade.setEmail("teste3@teste.com.br");
        entidade.setUsuario("teste.teste");
        entidade.setActive("S");
        entidade.setObservacao("observação");
        uR.save(entidade);

        try {
            uR.delete(entidade.getId());

            User u = new User();
            u.setEmail("teste3@teste.com.br");

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

        User entidade = new User();
        entidade.setEmail("teste5@teste.com.br");
        entidade.setUsuario("teste5.teste");
        entidade.setActive("S");
        entidade.setObservacao("observação5");
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

        User entidade = new User();
        entidade.setEmail("teste5@teste.com.br");
        entidade.setUsuario("teste5.teste");
        entidade.setActive("S");
        entidade.setObservacao("observação5");
        uR.save(entidade);

        try {
            List<DomainEntity> entidades = uR.findById(entidade.getId());
            resultado.setEntity(entidades);
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString() + " Message: " + e.getMessage());
        }

        Assertions.assertThat(resultado.getEntity()).isNotNull();
    }

}
