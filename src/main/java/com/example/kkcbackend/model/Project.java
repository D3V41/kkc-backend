package com.example.kkcbackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @NotNull
    private String projectName;

    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "ulbs",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Ulb> ulbs;

    public Project(Long projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public Project() {
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
