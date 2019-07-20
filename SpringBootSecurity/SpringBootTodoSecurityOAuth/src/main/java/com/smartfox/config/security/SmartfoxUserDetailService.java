package com.smartfox.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartfox.repository.UserAuthorityRepository;
import com.smartfox.repository.UserRepository;

@Service
public class SmartfoxUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new SmartfoxUserDetail(this.userRepository.findByUsername(username), this.userAuthorityRepository.findByUsername(username));
    }

}
