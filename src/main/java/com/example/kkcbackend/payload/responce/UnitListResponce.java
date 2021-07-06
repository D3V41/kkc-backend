package com.example.kkcbackend.payload.responce;

public class UnitListResponce {
    int unitId;
    String clusterName;
    int phase;
    String roadName;
    String ulbName;

    public UnitListResponce(int unitId, String clusterName, int phase, String roadName, String ulbName) {
        this.unitId = unitId;
        this.clusterName = clusterName;
        this.phase = phase;
        this.roadName = roadName;
        this.ulbName = ulbName;
    }

    public UnitListResponce() {
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getUlbName() {
        return ulbName;
    }

    public void setUlbName(String ulbName) {
        this.ulbName = ulbName;
    }
}
