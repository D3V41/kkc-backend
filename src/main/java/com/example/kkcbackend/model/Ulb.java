package com.example.kkcbackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "ulbs")
public class Ulb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long ulbId;

    @NotNull
    private String uldName;

    @NotNull
    private String clusterName;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "project_id",nullable = false)
    private Project project;

    public Ulb() {
    }

    public Ulb(Long ulbId, String uldName, String clusterName, Project project) {
        this.ulbId = ulbId;
        this.uldName = uldName;
        this.clusterName = clusterName;
        this.project = project;
    }

    public Long getUlbId() {
        return ulbId;
    }

    public void setUlbId(Long ulbId) {
        this.ulbId = ulbId;
    }

    public String getUldName() {
        return uldName;
    }

    public void setUldName(String uldName) {
        this.uldName = uldName;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
