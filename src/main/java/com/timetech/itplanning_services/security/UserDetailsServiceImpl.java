package com.timetech.itplanning_services.security;

import com.timetech.itplanning_services.dao.UserRepository;
import com.timetech.itplanning_services.model.User;
import com.timetech.itplanning_services.model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("Cannot locate the User with this username.");
        }

        return new UserDetailsImpl(user);
    }
}
