package com.example.kkcbackend.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

import com.example.kkcbackend.model.User;
import org.springframework.security.core.userdetails.UserDetails;


public class AdminDetails implements UserDetails {
    private Long projectId;
    private String userName;
    private String userPassword;
    private String clusterName;
    private Set<GrantedAuthority> authorities;

    public AdminDetails(Long projectId, String userName, String userPassword, String clusterName, Set<GrantedAuthority> authorities) {
        this.projectId = projectId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.clusterName = clusterName;
        this.authorities = authorities;
    }

    public static AdminDetails build(User user){
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new AdminDetails(
                user.getProject().getProjectId(),
                user.getUserName(),
                user.getPassword(),
                user.getClusterName(),
                authorities);

    }

    public Long getProjectId() {
        return projectId;
    }

    public String getClusterName() {
        return clusterName;
    }

    @Override
    public String toString() {
        return "{" +
                "'projectId':" + projectId +
                ", 'userName':'" + userName + '\'' +
                ", 'clusterName':'" + clusterName + '\''+"}";
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
