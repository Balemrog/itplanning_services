package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserByLogin(String login);
    List<User> getAllUser();
    User saveUser(User user);
    void deleteUser(Integer id);

    boolean hasUserWithLogin(String login);
    Optional<User> validLoginAndPassword(String login, String password);
}
