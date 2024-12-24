package com.example.demo_petstore.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo_petstore.model.User;
import com.example.demo_petstore.repository.userRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final userRepository userRepository;

    public UserDetailsServiceImpl(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getNombreUsuario(),
                user.getContrasena(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())) // Use the role as authority
        );
    }
}
