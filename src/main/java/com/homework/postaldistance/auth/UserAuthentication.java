package com.homework.postaldistance.auth;

import com.homework.postaldistance.model.ServiceUser;
import com.homework.postaldistance.repository.ServiceUserRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Milos
 */
@Component
public class UserAuthentication implements UserDetailsService {

    @Autowired
    private ServiceUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ServiceUser user = repository.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

        return new User(user.getUserName(), user.getPassword(), authorities);
    }
}

