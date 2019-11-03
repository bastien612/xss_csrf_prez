package com.laboratoire.xss_csrf.service.impl;

import com.laboratoire.xss_csrf.model.CustomerModel;
import com.laboratoire.xss_csrf.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AppUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CustomerModel customer = repository.findByLogin(s);

        if(customer == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("user"));

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(customer.getLogin(), customer.getPassword(), authorities);

        return userDetails;
    }
}
