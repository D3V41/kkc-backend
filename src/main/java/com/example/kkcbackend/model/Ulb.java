package com.example.kkcbackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ulbs")
public class Ulb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long ulbId;

    @NotNull
    private String ulbName;

    @NotNull
    private String clusterName;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "project_id",nullable = false)
    private Project project;

    @OneToMany(mappedBy = "ulb",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Unit> units;

    public Ulb() {
    }

    public Ulb(Long ulbId, String ulbName, String clusterName, Project project) {
        this.ulbId = ulbId;
        this.ulbName = ulbName;
        this.clusterName = clusterName;
        this.project = project;
    }

    public Long getUlbId() {
        return ulbId;
    }

    public void setUlbId(Long ulbId) {
        this.ulbId = ulbId;
    }

    public String getUlbName() {
        return ulbName;
    }

    public void setUlbName(String ulbName) {
        this.ulbName = ulbName;
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
