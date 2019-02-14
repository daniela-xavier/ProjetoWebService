/*
 * MyUserDetails.java
 *
 * Created on 14-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */
package com.proj.wsf.view.filter;

import com.proj.wsf.mod.user.core.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Description the class MyUserDetails - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 14/02/2019
 */
public class MyUserDetailsimplements implements UserDetailsService {

  @Autowired
        private UserRepository userRepository;

  @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final User user = userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    return org.springframework.security.core.userdetails.User//
        .withUsername(username)//
        .password(user.getPassword())//
        .authorities(user.getRoles())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }
}
