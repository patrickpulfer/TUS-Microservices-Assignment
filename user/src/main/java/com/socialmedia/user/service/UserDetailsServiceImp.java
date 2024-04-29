package com.socialmedia.user.service;


import com.socialmedia.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository respository;

    public UserDetailsServiceImp(UserRepository respository) {
        this.respository = respository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return respository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
