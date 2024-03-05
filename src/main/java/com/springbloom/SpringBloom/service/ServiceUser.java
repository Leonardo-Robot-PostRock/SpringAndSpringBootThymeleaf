package com.springbloom.SpringBloom.service;

import com.springbloom.SpringBloom.dao.UserDao;
import com.springbloom.SpringBloom.domain.Rol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.springbloom.SpringBloom.domain.Account;
import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mrRobot
 */
@Service("userDeteailsService")
@Slf4j
public class ServiceUser implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = userDao.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        var roles = new ArrayList<GrantedAuthority>();

        for (Rol rol : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getName()));
        }

        return new User(user.getUsername(), user.getPassword(), roles);
    }

}
