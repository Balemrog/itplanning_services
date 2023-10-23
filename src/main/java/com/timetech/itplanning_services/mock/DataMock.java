package com.timetech.itplanning_services.mock;

import com.timetech.itplanning_services.model.Role;
import com.timetech.itplanning_services.model.User;
import com.timetech.itplanning_services.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataMock implements CommandLineRunner {

    private final UserService service;

    public DataMock(UserService userService) {
        this.service = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        String login = "service.planning@campus-eni.fr";
        if(!service.hasUserWithLogin(login)) {
            User user = new User(login, "password", Role.SERVICE_PLANNING);
            service.saveUser(user);
        }
    }
}
