package com.example.kkcbackend.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.validation.Valid;

public class LoginRequest {
    @NotNull
    String userName;
    @NotNull
    String password;
    @NotNull
    String clusterName;
    @NotNull
    Long projectId;

    public LoginRequest(String userName, String password, String clusterName, Long projectId) {
        this.userName = userName;
        this.password = password;
        this.clusterName = clusterName;
        this.projectId = projectId;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
