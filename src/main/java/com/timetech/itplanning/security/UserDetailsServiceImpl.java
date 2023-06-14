package com.timetech.itplanning.security;

import com.timetech.itplanning.dao.UserRepository;
import com.timetech.itplanning.model.User;
import com.timetech.itplanning.model.UserDetailsImpl;
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
