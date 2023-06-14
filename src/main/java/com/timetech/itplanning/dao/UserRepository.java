package com.timetech.itplanning.dao;

import com.timetech.itplanning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByLogin(String login);
}