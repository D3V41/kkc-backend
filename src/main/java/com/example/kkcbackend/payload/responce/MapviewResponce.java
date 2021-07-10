package com.example.kkcbackend.payload.responce;

public class MapviewResponce {
    int unitId;
    String roadName;
    float longitude;
    float latitude;

    public MapviewResponce(int unitId, String roadName, float longitude, float latitude) {
        this.unitId = unitId;
        this.roadName = roadName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public MapviewResponce() {
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
