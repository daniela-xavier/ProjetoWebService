package com.proj.wsf.model;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @brief Classe PermissionTest Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date 14/02/2019
 * @version %I%, %G%
 * @since 1.0
 */
public class PermissionTest {

    @Test
    public void testConstrutor() {

        List<Permission> permissoes = new ArrayList<Permission>();
        permissoes.add(new Permission("OnSave", Boolean.TRUE));
        permissoes.add(new Permission("OnUpdate", Boolean.TRUE));
        permissoes.add(new Permission("OnDisable", Boolean.TRUE));
        permissoes.add(new Permission("OnFindAll", Boolean.TRUE));
        
        Rule rule =  new Rule("User", permissoes);
        Assertions.assertThat(rule).isNotNull();

    }

}
