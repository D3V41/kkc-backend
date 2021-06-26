package com.example.kkcbackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    //Device Id
    @NotNull
    private int imei;

    @NotNull
    private int unitId;

    @NotNull
    private String ulbName;

    @NotNull
    private String meterNo;

    @NotNull
    private String clusterName;

    @NotNull
    private String roadName;

    @NotNull
    private float ledRating;

    @NotNull
    private float totalLoad;

    @NotNull
    private int noOfFixture;

    @NotNull
    private String typeOfLoad;

    @NotNull
    private int mobile;

    @NotNull
    private int phase;

    @NotNull
    private float latitude;

    @NotNull
    private float longitude;

    @NotNull
    private String commandMode;


    public Unit() {
    }

    public Unit(Long id) {
        this.id = id;
    }

    public Unit(Long id, int imei, int unitId, String ulbName, String meterNo, String clusterName, String roadName, float ledRating, float totalLoad, int noOfFixture, String typeOfLoad, int mobile, int phase, float latitude, float longitude, String commandMode) {
        this.id = id;
        this.imei = imei;
        this.unitId = unitId;
        this.ulbName = ulbName;
        this.meterNo = meterNo;
        this.clusterName = clusterName;
        this.roadName = roadName;
        this.ledRating = ledRating;
        this.totalLoad = totalLoad;
        this.noOfFixture = noOfFixture;
        this.typeOfLoad = typeOfLoad;
        this.mobile = mobile;
        this.phase = phase;
        this.latitude = latitude;
        this.longitude = longitude;
        this.commandMode = commandMode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUlbName() {
        return ulbName;
    }

    public void setUlbName(String ulbName) {
        this.ulbName = ulbName;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public float getLedRating() {
        return ledRating;
    }

    public void setLedRating(float ledRating) {
        this.ledRating = ledRating;
    }

    public float getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(float totalLoad) {
        this.totalLoad = totalLoad;
    }

    public int getNoOfFixture() {
        return noOfFixture;
    }

    public void setNoOfFixture(int noOfFixture) {
        this.noOfFixture = noOfFixture;
    }

    public String getTypeOfLoad() {
        return typeOfLoad;
    }

    public void setTypeOfLoad(String typeOfLoad) {
        this.typeOfLoad = typeOfLoad;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getCommandMode() {
        return commandMode;
    }

    public void setCommandMode(String commandMode) {
        this.commandMode = commandMode;
    }
}
