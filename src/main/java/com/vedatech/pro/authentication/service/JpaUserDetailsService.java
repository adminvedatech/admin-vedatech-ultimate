package com.vedatech.pro.authentication.service;

import com.vedatech.pro.model.user.Role;
import com.vedatech.pro.model.user.UserLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.vedatech.pro.repository.UserLogDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

    public final UserLogDao userLogDao;

    public JpaUserDetailsService(UserLogDao userLogDao) {
        this.userLogDao = userLogDao;
    }

    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);


    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserLog user = userLogDao.findByUsername(username);

        if(user == null) {
            logger.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
            throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(Role role: user.getRoles()) {
            logger.info("Role: ".concat(role.getAuthority()));
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        if(authorities.isEmpty()) {
            logger.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
            throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }

        return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
    }
}
