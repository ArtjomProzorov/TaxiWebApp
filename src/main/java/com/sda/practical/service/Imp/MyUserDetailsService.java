package com.sda.practical.service.Imp;

import java.util.ArrayList;
import java.util.Collection;
import com.sda.practical.model.User;
import com.sda.practical.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User name "+username+" not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getGrantedAuthorities(user));
    }
 // Strantegy pattern  >> based on condition > creating new object

    private Collection<GrantedAuthority> getGrantedAuthorities(User user) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(user.getRole().getName().equals("admin")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if(user.getRole().getName().equals("driver")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_DRIVER"));
        }
        if(user.getRole().getName().equals("user")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return grantedAuthorities;
    }
}