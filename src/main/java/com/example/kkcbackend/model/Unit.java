package com.example.kkcbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="units")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    //Device Id
    @NotNull
    private Long imei;

    @NotNull
    private int unitId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "ulb_id",nullable = false)
    private Ulb ulb;

    @OneToMany(mappedBy = "unit",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Data> data;

//    @NotNull
//    private String ulbName;

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
    private Long mobile;

    @NotNull
    private int phase;

    @NotNull
    private float latitude;

    @NotNull
    private float longitude;

    @NotNull
    private String commandMode;

    @NotNull
    private int ward;


    public Unit() {
    }

    public Unit(Long id) {
        this.id = id;
    }

    public Unit(Long id, Long imei, int unitId, Ulb ulb, String meterNo, String clusterName,
                String roadName, float ledRating, float totalLoad, int noOfFixture,
                String typeOfLoad, Long mobile, int phase, float latitude, float longitude,
                String commandMode) {
        this.id = id;
        this.imei = imei;
        this.unitId = unitId;
        this.ulb = ulb;
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

    public Unit(Long imei, int unitId, Ulb ulb, String meterNo, String clusterName,
                String roadName, float ledRating, float totalLoad, int noOfFixture,
                String typeOfLoad, Long mobile, int phase, float latitude, float longitude,
                String commandMode) {
        this.imei = imei;
        this.unitId = unitId;
        this.ulb = ulb;
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

    public Unit(Long imei, int unitId, Ulb ulb, String meterNo, String clusterName, String roadName, float ledRating, float totalLoad, int noOfFixture, String typeOfLoad, Long mobile, int phase, float latitude, float longitude, String commandMode, int ward) {
        this.imei = imei;
        this.unitId = unitId;
        this.ulb = ulb;
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
        this.ward = ward;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
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

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Ulb getUlb() {
        return ulb;
    }

    public void setUlb(Ulb ulb) {
        this.ulb = ulb;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
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
