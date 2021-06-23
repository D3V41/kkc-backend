package com.example.kkcbackend.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

import com.example.kkcbackend.model.User;
import org.springframework.security.core.userdetails.UserDetails;


public class AdminDetails implements UserDetails {
    private String userName;
    private String userPassword;
    private Set<GrantedAuthority> authorities;

    public AdminDetails(String userName, String userPassword, Set<GrantedAuthority> authorities) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.authorities = authorities;
    }

    public static AdminDetails build(User user){
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new AdminDetails(
                user.getUserName(),
                user.getPassword(),
                authorities);

    }

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
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
