
package com.proj.wsf.mod.user.core.service;

import com.proj.wsf.core.IRepository;
import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.test.IServiceTest;
import com.proj.wsf.mod.user.core.dao.UserDAO;
import com.proj.wsf.mod.user.core.repository.UserRepository;
import com.proj.wsf.mod.user.core.strategy.UserStrategy;
import com.proj.wsf.mod.user.model.User;
import com.proj.wsf.view.config.JPAConfiguration;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
 * @brief Classe UserServiceTest
 * Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date   05/02/2019
 * @version     %I%, %G%
 * @since       1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAConfiguration.class)
@ContextConfiguration(classes = { UserDAO.class,User.class, UserRepository.class,
    UserService.class, UserStrategy.class})
@ActiveProfiles("dev")
public class UserServiceTest implements IServiceTest {

    @Autowired
    UserService uServico;

    @Test
    @Override
    public void getRepository() {
        IRepository repository = this.uServico.getRepository();
        Assertions.assertThat(repository).isNotNull();
    }

    @Test
    @Override
    public void getStrategys() {
        Map<String, List<IStrategy>> mapaDeRegras = this.uServico.getStrategys();
        System.out.println("Quantidade de strategys.: " + mapaDeRegras.size());
        Set<String> keySet = mapaDeRegras.keySet();

        Assertions.assertThat(mapaDeRegras).isNotNull();
        Assertions.assertThat(keySet).isNotNull();
        
        for (String nomeRegra : keySet) {
            Assertions.assertThat(nomeRegra).isNotNull();
            List<IStrategy> regras = mapaDeRegras.get(nomeRegra); 
            Assertions.assertThat(regras).isNotNull();
            Assertions.assertThat(regras.size()).isNotEqualTo(0);
            System.out.println("Regra .: " + nomeRegra +"\n Quantidade de regras de " + nomeRegra + " .: " + regras.size());
            for (IStrategy regra : regras) {
                 System.out.println("Classe regra.:" + regra.getClass().getSimpleName());
            }
        }

    }

    @Test
    @Override
    public void getClasse() {
        Class<?> classe = uServico.getClasse();
        Assertions.assertThat(classe.getSimpleName()).contains("User");
    }

    @Test
    @Override
    public void getEntidadeNome() {
        String entidadeNome = uServico.getEntidadeNome();
        Assertions.assertThat(entidadeNome).contains("User");
    }

}
