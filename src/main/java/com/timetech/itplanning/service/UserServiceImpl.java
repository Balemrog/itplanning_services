package com.timetech.itplanning.service;

import com.timetech.itplanning.dao.UserRepository;
import com.timetech.itplanning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public User getUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public List<User> getAllMembers() {
        return repository.findAll();
    }
}
