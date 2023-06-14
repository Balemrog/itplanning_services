package com.timetech.itplanning.service;

import com.timetech.itplanning.model.User;

import java.util.List;

public interface UserService {

    User getUserByLogin(String login);
    List<User> getAllMembers();
}
