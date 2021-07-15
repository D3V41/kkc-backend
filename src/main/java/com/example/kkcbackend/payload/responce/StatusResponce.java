package com.example.kkcbackend.payload.responce;

import java.util.Date;

public class StatusResponce {
    int srNo;
    Date timestamp;
    String zone;
    int ward;
    String roadName;
    int unitId;
    Boolean status;
    String onTime;
    String offTime;
    float kwh;
    float iTotal;
    float kwTotal;
    String eventType;
    float totalloadwattage;
    Long imei;

    public StatusResponce(Date timestamp, String zone, int ward, String roadName, int unitId, Boolean status, String onTime, String offTime, float kwh, float iTotal, float kwTotal, String eventType, float totalloadwattage) {
        this.timestamp = timestamp;
        this.zone = zone;
        this.ward = ward;
        this.roadName = roadName;
        this.unitId = unitId;
        this.status = status;
        this.onTime = onTime;
        this.offTime = offTime;
        this.kwh = kwh;
        this.iTotal = iTotal;
        this.kwTotal = kwTotal;
        this.eventType = eventType;
        this.totalloadwattage = totalloadwattage;
    }

    public StatusResponce(int srNo, Date timestamp, String zone, int ward, String roadName, int unitId, Boolean status, String onTime, String offTime, float kwh, float iTotal, float kwTotal, String eventType, float totalloadwattage) {
        this.srNo = srNo;
        this.timestamp = timestamp;
        this.zone = zone;
        this.ward = ward;
        this.roadName = roadName;
        this.unitId = unitId;
        this.status = status;
        this.onTime = onTime;
        this.offTime = offTime;
        this.kwh = kwh;
        this.iTotal = iTotal;
        this.kwTotal = kwTotal;
        this.eventType = eventType;
        this.totalloadwattage = totalloadwattage;
    }

    public StatusResponce(int srNo, Date timestamp, String zone, int ward, String roadName, int unitId, Boolean status, String onTime, String offTime, float kwh, float iTotal, float kwTotal, String eventType, float totalloadwattage, Long imei) {
        this.srNo = srNo;
        this.timestamp = timestamp;
        this.zone = zone;
        this.ward = ward;
        this.roadName = roadName;
        this.unitId = unitId;
        this.status = status;
        this.onTime = onTime;
        this.offTime = offTime;
        this.kwh = kwh;
        this.iTotal = iTotal;
        this.kwTotal = kwTotal;
        this.eventType = eventType;
        this.totalloadwattage = totalloadwattage;
        this.imei = imei;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public StatusResponce() {
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getOnTime() {
        return onTime;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }

    public String getOffTime() {
        return offTime;
    }

    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }

    public float getKwh() {
        return kwh;
    }

    public void setKwh(float kwh) {
        this.kwh = kwh;
    }

    public float getiTotal() {
        return iTotal;
    }

    public void setiTotal(float iTotal) {
        this.iTotal = iTotal;
    }

    public float getKwTotal() {
        return kwTotal;
    }

    public void setKwTotal(float kwTotal) {
        this.kwTotal = kwTotal;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public float getTotalloadwattage() {
        return totalloadwattage;
    }

    public void setTotalloadwattage(float totalloadwattage) {
        this.totalloadwattage = totalloadwattage;
    }
}
