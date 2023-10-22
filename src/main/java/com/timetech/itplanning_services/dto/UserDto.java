package com.timetech.itplanning_services.dto;

import com.timetech.itplanning_services.model.Role;

public class UserDto {

    private int id;
    private String login;
    private Role role;

    public UserDto() {
    }

    public UserDto(int id, String login, Role role) {
        this.id = id;
        this.login = login;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String email) {
        this.login = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
