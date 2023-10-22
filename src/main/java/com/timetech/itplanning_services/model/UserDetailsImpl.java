package com.timetech.itplanning_services.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private List<GrantedAuthority> authorities;

    private User user;

    public UserDetailsImpl(User user){
        this.user = user;
        switch (user.getRole()) {
            case SERVICE_PLANNING:
                this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_SERVICE_PLANNING"),
                        new SimpleGrantedAuthority("ROLE_TEACHER"),
                        new SimpleGrantedAuthority("ROLE_STUDENT"));
                break;
            case TEACHER:
                this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_TEACHER"),
                        new SimpleGrantedAuthority("ROLE_STUDENT"));
                break;
            default:
                this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_STUDENT"));
                break;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
