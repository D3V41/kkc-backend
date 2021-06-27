package com.example.kkcbackend.payload.request;

import com.sun.istack.NotNull;

public class UlbRequest {
    private Long ulbId;
    @NotNull
    private String ulbName;

    @NotNull
    private String clusterName;

    @NotNull
    private Long projectId;

    public UlbRequest() {
    }

    public UlbRequest(String ulbName, String clusterName, Long projectId) {
        this.ulbName = ulbName;
        this.clusterName = clusterName;
        this.projectId = projectId;
    }

    public UlbRequest(Long ulbId, String ulbName, String clusterName, Long projectId) {
        this.ulbId = ulbId;
        this.ulbName = ulbName;
        this.clusterName = clusterName;
        this.projectId = projectId;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
