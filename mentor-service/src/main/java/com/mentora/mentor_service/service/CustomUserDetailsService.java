package com.mentora.mentor_service.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // For now, return a dummy user. Later connect to DB.
        return org.springframework.security.core.userdetails.User
                .withUsername(email)
                .password("{noop}password") // {noop} means no password encoding
                .roles("USER")
                .build();
    }
}
