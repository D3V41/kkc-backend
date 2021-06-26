package com.example.kkcbackend.payload.request;

import com.sun.istack.NotNull;

public class SignUpRequest {
    @NotNull
    String userName;
    @NotNull
    String password;
    @NotNull
    String clusterName;
    @NotNull
    Long projectId;
    @NotNull
    Boolean editAccess;

    public SignUpRequest(String userName, String password, String clusterName, Long projectId, Boolean editAccess) {
        this.userName = userName;
        this.password = password;
        this.clusterName = clusterName;
        this.projectId = projectId;
        this.editAccess = editAccess;
    }

    public Boolean getEditAccess() {
        return editAccess;
    }

    public void setEditAccess(Boolean editAccess) {
        this.editAccess = editAccess;
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
