package com.timetech.itplanning_backend.dao;

import com.timetech.itplanning_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByLogin(String login);
}