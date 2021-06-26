package com.example.kkcbackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String clusterName;

    @NotNull
    private Boolean editAccess;

//    @NotNull
//    private Long projectId;

    @NotNull
    private String password;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "project_id",nullable = false)
    private Project project;

    public User(Long id) {
        this.id = id;
    }

    public User() {
    }

//    public User(Long id, String userName, String clusterName, Boolean editAccess, Long projectId, String password) {
//        this.id = id;
//        this.userName = userName;
//        this.clusterName = clusterName;
//        this.editAccess = editAccess;
//        this.projectId = projectId;
//        this.password = password;
//    }


    public User(Long id, String userName, String clusterName, Boolean editAccess, String password, Project project) {
        this.id = id;
        this.userName = userName;
        this.clusterName = clusterName;
        this.editAccess = editAccess;
        this.password = password;
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Boolean getEditAccess() {
        return editAccess;
    }

    public void setEditAccess(Boolean editAccess) {
        this.editAccess = editAccess;
    }

//    public Long getProjectId() {
//        return projectId;
//    }
//
//    public void setProjectId(Long projectId) {
//        this.projectId = projectId;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
