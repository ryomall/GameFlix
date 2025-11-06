package com.gameflix.gameflix.config;

import com.gameflix.gameflix.model.User;
import com.gameflix.gameflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {
@Autowired
private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.out.println("hello" + user.toString());
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .authorities(new ArrayList<>())
                .password(user.getPassword())
                .build();
    }
}
