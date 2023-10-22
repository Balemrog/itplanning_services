package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.User;

import java.util.List;

public interface UserService {

    User getUserByLogin(String login);
    List<User> getAllMembers();
    void saveUser(User user);
}
