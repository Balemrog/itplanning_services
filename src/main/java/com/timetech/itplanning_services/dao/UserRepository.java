package com.timetech.itplanning_services.dao;

import com.timetech.itplanning_services.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByLogin(String login);
}