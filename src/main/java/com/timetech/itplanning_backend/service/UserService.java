package com.timetech.itplanning_backend.service;

import com.timetech.itplanning_backend.model.User;

import java.util.List;

public interface UserService {

    User getUserByLogin(String login);
    List<User> getAllMembers();
}
