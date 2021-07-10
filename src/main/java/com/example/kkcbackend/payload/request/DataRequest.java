package com.example.kkcbackend.payload.request;

import com.sun.istack.NotNull;

import java.util.Date;

public class DataRequest {
    @NotNull
    private Long id;

    @NotNull
    private String eventType;

    @NotNull
    private int unitId;

    @NotNull
    private int minute;

    @NotNull
    private int hour;

    @NotNull
    private int day;

    @NotNull
    private int month;

    @NotNull
    private int year;

    @NotNull
    private Date timestamp;

    @NotNull
    private float voltage_R_Phase;

    @NotNull
    private float voltage_Y_Phase;

    @NotNull
    private float voltage_B_Phase;

    @NotNull
    private float current_R_Phase;

    @NotNull
    private float current_Y_Phase;

    @NotNull
    private float current_B_Phase;

    @NotNull
    private float powerFactor_R_Phase;

    @NotNull
    private float powerFactor_Y_Phase;

    @NotNull
    private float powerFactor_B_Phase;

    @NotNull
    private float kwh;

    @NotNull
    private float kvah;

    @NotNull
    private float voltage_THD_R_Phase_Percentage;

    @NotNull
    private float voltage_THD_Y_Phase_Percentage;

    @NotNull
    private float voltage_THD_B_Phase_Percentage;

    @NotNull
    private float current_THD_R_Phase_Percentage;

    @NotNull
    private float current_THD_Y_Phase_Percentage;

    @NotNull
    private float current_THD_B_Phase_Percentage;

    @NotNull
    private int r_Light_Failure;

    @NotNull
    private int y_Light_Failure;

    @NotNull
    private float powerFailHRs;

    @NotNull
    private String faultByte;

    @NotNull
    private String prime_Mode_ON_TIME;

    @NotNull
    private String prime_Mode_OFF_TIME;

    @NotNull
    private String dimmed_ON_TIME;

    @NotNull
    private String dimmed_OFF_TIME;

    @NotNull
    private String longitude_AXIS;

    @NotNull
    private String latitude_AXIS;

    @NotNull
    private String rYB_Image;

    @NotNull
    private String s1S2BoostOutputImage;

    @NotNull
    private String auxInputImage;

    @NotNull
    private String earthCurrent;

    @NotNull
    private String lEDDaywiseGlowingHours;

    @NotNull
    private String lEDDaywiseNonGlowingHours;

    @NotNull
    private String bLight_failure;

    @NotNull
    private Date createdOn;

    @NotNull
    private String rawString;

    public DataRequest(Long id, String eventType, int unitId, int minute, int hour, int day, int month, int year, Date timestamp, float voltage_R_Phase, float voltage_Y_Phase, float voltage_B_Phase, float current_R_Phase, float current_Y_Phase, float current_B_Phase, float powerFactor_R_Phase, float powerFactor_Y_Phase, float powerFactor_B_Phase, float kwh, float kvah, float voltage_THD_R_Phase_Percentage, float voltage_THD_Y_Phase_Percentage, float voltage_THD_B_Phase_Percentage, float current_THD_R_Phase_Percentage, float current_THD_Y_Phase_Percentage, float current_THD_B_Phase_Percentage, int r_Light_Failure, int y_Light_Failure, float powerFailHRs, String faultByte, String prime_Mode_ON_TIME, String prime_Mode_OFF_TIME, String dimmed_ON_TIME, String dimmed_OFF_TIME, String longitude_AXIS, String latitude_AXIS, String rYB_Image, String s1S2BoostOutputImage, String auxInputImage, String earthCurrent, String lEDDaywiseGlowingHours, String lEDDaywiseNonGlowingHours, String bLight_failure, Date createdOn, String rawString) {
        this.id = id;
        this.eventType = eventType;
        this.unitId = unitId;
        this.minute = minute;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
        this.timestamp = timestamp;
        this.voltage_R_Phase = voltage_R_Phase;
        this.voltage_Y_Phase = voltage_Y_Phase;
        this.voltage_B_Phase = voltage_B_Phase;
        this.current_R_Phase = current_R_Phase;
        this.current_Y_Phase = current_Y_Phase;
        this.current_B_Phase = current_B_Phase;
        this.powerFactor_R_Phase = powerFactor_R_Phase;
        this.powerFactor_Y_Phase = powerFactor_Y_Phase;
        this.powerFactor_B_Phase = powerFactor_B_Phase;
        this.kwh = kwh;
        this.kvah = kvah;
        this.voltage_THD_R_Phase_Percentage = voltage_THD_R_Phase_Percentage;
        this.voltage_THD_Y_Phase_Percentage = voltage_THD_Y_Phase_Percentage;
        this.voltage_THD_B_Phase_Percentage = voltage_THD_B_Phase_Percentage;
        this.current_THD_R_Phase_Percentage = current_THD_R_Phase_Percentage;
        this.current_THD_Y_Phase_Percentage = current_THD_Y_Phase_Percentage;
        this.current_THD_B_Phase_Percentage = current_THD_B_Phase_Percentage;
        this.r_Light_Failure = r_Light_Failure;
        this.y_Light_Failure = y_Light_Failure;
        this.powerFailHRs = powerFailHRs;
        this.faultByte = faultByte;
        this.prime_Mode_ON_TIME = prime_Mode_ON_TIME;
        this.prime_Mode_OFF_TIME = prime_Mode_OFF_TIME;
        this.dimmed_ON_TIME = dimmed_ON_TIME;
        this.dimmed_OFF_TIME = dimmed_OFF_TIME;
        this.longitude_AXIS = longitude_AXIS;
        this.latitude_AXIS = latitude_AXIS;
        this.rYB_Image = rYB_Image;
        this.s1S2BoostOutputImage = s1S2BoostOutputImage;
        this.auxInputImage = auxInputImage;
        this.earthCurrent = earthCurrent;
        this.lEDDaywiseGlowingHours = lEDDaywiseGlowingHours;
        this.lEDDaywiseNonGlowingHours = lEDDaywiseNonGlowingHours;
        this.bLight_failure = bLight_failure;
        this.createdOn = createdOn;
        this.rawString = rawString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public float getVoltage_R_Phase() {
        return voltage_R_Phase;
    }

    public void setVoltage_R_Phase(float voltage_R_Phase) {
        this.voltage_R_Phase = voltage_R_Phase;
    }

    public float getVoltage_Y_Phase() {
        return voltage_Y_Phase;
    }

    public void setVoltage_Y_Phase(float voltage_Y_Phase) {
        this.voltage_Y_Phase = voltage_Y_Phase;
    }

    public float getVoltage_B_Phase() {
        return voltage_B_Phase;
    }

    public void setVoltage_B_Phase(float voltage_B_Phase) {
        this.voltage_B_Phase = voltage_B_Phase;
    }

    public float getCurrent_R_Phase() {
        return current_R_Phase;
    }

    public void setCurrent_R_Phase(float current_R_Phase) {
        this.current_R_Phase = current_R_Phase;
    }

    public float getCurrent_Y_Phase() {
        return current_Y_Phase;
    }

    public void setCurrent_Y_Phase(float current_Y_Phase) {
        this.current_Y_Phase = current_Y_Phase;
    }

    public float getCurrent_B_Phase() {
        return current_B_Phase;
    }

    public void setCurrent_B_Phase(float current_B_Phase) {
        this.current_B_Phase = current_B_Phase;
    }

    public float getPowerFactor_R_Phase() {
        return powerFactor_R_Phase;
    }

    public void setPowerFactor_R_Phase(float powerFactor_R_Phase) {
        this.powerFactor_R_Phase = powerFactor_R_Phase;
    }

    public float getPowerFactor_Y_Phase() {
        return powerFactor_Y_Phase;
    }

    public void setPowerFactor_Y_Phase(float powerFactor_Y_Phase) {
        this.powerFactor_Y_Phase = powerFactor_Y_Phase;
    }

    public float getPowerFactor_B_Phase() {
        return powerFactor_B_Phase;
    }

    public void setPowerFactor_B_Phase(float powerFactor_B_Phase) {
        this.powerFactor_B_Phase = powerFactor_B_Phase;
    }

    public float getKwh() {
        return kwh;
    }

    public void setKwh(float kwh) {
        this.kwh = kwh;
    }

    public float getKvah() {
        return kvah;
    }

    public void setKvah(float kvah) {
        this.kvah = kvah;
    }

    public float getVoltage_THD_R_Phase_Percentage() {
        return voltage_THD_R_Phase_Percentage;
    }

    public void setVoltage_THD_R_Phase_Percentage(float voltage_THD_R_Phase_Percentage) {
        this.voltage_THD_R_Phase_Percentage = voltage_THD_R_Phase_Percentage;
    }

    public float getVoltage_THD_Y_Phase_Percentage() {
        return voltage_THD_Y_Phase_Percentage;
    }

    public void setVoltage_THD_Y_Phase_Percentage(float voltage_THD_Y_Phase_Percentage) {
        this.voltage_THD_Y_Phase_Percentage = voltage_THD_Y_Phase_Percentage;
    }

    public float getVoltage_THD_B_Phase_Percentage() {
        return voltage_THD_B_Phase_Percentage;
    }

    public void setVoltage_THD_B_Phase_Percentage(float voltage_THD_B_Phase_Percentage) {
        this.voltage_THD_B_Phase_Percentage = voltage_THD_B_Phase_Percentage;
    }

    public float getCurrent_THD_R_Phase_Percentage() {
        return current_THD_R_Phase_Percentage;
    }

    public void setCurrent_THD_R_Phase_Percentage(float current_THD_R_Phase_Percentage) {
        this.current_THD_R_Phase_Percentage = current_THD_R_Phase_Percentage;
    }

    public float getCurrent_THD_Y_Phase_Percentage() {
        return current_THD_Y_Phase_Percentage;
    }

    public void setCurrent_THD_Y_Phase_Percentage(float current_THD_Y_Phase_Percentage) {
        this.current_THD_Y_Phase_Percentage = current_THD_Y_Phase_Percentage;
    }

    public float getCurrent_THD_B_Phase_Percentage() {
        return current_THD_B_Phase_Percentage;
    }

    public void setCurrent_THD_B_Phase_Percentage(float current_THD_B_Phase_Percentage) {
        this.current_THD_B_Phase_Percentage = current_THD_B_Phase_Percentage;
    }

    public int getR_Light_Failure() {
        return r_Light_Failure;
    }

    public void setR_Light_Failure(int r_Light_Failure) {
        this.r_Light_Failure = r_Light_Failure;
    }

    public int getY_Light_Failure() {
        return y_Light_Failure;
    }

    public void setY_Light_Failure(int y_Light_Failure) {
        this.y_Light_Failure = y_Light_Failure;
    }

    public float getPowerFailHRs() {
        return powerFailHRs;
    }

    public void setPowerFailHRs(float powerFailHRs) {
        this.powerFailHRs = powerFailHRs;
    }

    public String getFaultByte() {
        return faultByte;
    }

    public void setFaultByte(String faultByte) {
        this.faultByte = faultByte;
    }

    public String getPrime_Mode_ON_TIME() {
        return prime_Mode_ON_TIME;
    }

    public void setPrime_Mode_ON_TIME(String prime_Mode_ON_TIME) {
        this.prime_Mode_ON_TIME = prime_Mode_ON_TIME;
    }

    public String getPrime_Mode_OFF_TIME() {
        return prime_Mode_OFF_TIME;
    }

    public void setPrime_Mode_OFF_TIME(String prime_Mode_OFF_TIME) {
        this.prime_Mode_OFF_TIME = prime_Mode_OFF_TIME;
    }

    public String getDimmed_ON_TIME() {
        return dimmed_ON_TIME;
    }

    public void setDimmed_ON_TIME(String dimmed_ON_TIME) {
        this.dimmed_ON_TIME = dimmed_ON_TIME;
    }

    public String getDimmed_OFF_TIME() {
        return dimmed_OFF_TIME;
    }

    public void setDimmed_OFF_TIME(String dimmed_OFF_TIME) {
        this.dimmed_OFF_TIME = dimmed_OFF_TIME;
    }

    public String getLongitude_AXIS() {
        return longitude_AXIS;
    }

    public void setLongitude_AXIS(String longitude_AXIS) {
        this.longitude_AXIS = longitude_AXIS;
    }

    public String getLatitude_AXIS() {
        return latitude_AXIS;
    }

    public void setLatitude_AXIS(String latitude_AXIS) {
        this.latitude_AXIS = latitude_AXIS;
    }

    public String getrYB_Image() {
        return rYB_Image;
    }

    public void setrYB_Image(String rYB_Image) {
        this.rYB_Image = rYB_Image;
    }

    public String getS1S2BoostOutputImage() {
        return s1S2BoostOutputImage;
    }

    public void setS1S2BoostOutputImage(String s1S2BoostOutputImage) {
        this.s1S2BoostOutputImage = s1S2BoostOutputImage;
    }

    public String getAuxInputImage() {
        return auxInputImage;
    }

    public void setAuxInputImage(String auxInputImage) {
        this.auxInputImage = auxInputImage;
    }

    public String getEarthCurrent() {
        return earthCurrent;
    }

    public void setEarthCurrent(String earthCurrent) {
        this.earthCurrent = earthCurrent;
    }

    public String getlEDDaywiseGlowingHours() {
        return lEDDaywiseGlowingHours;
    }

    public void setlEDDaywiseGlowingHours(String lEDDaywiseGlowingHours) {
        this.lEDDaywiseGlowingHours = lEDDaywiseGlowingHours;
    }

    public String getlEDDaywiseNonGlowingHours() {
        return lEDDaywiseNonGlowingHours;
    }

    public void setlEDDaywiseNonGlowingHours(String lEDDaywiseNonGlowingHours) {
        this.lEDDaywiseNonGlowingHours = lEDDaywiseNonGlowingHours;
    }

    public String getbLight_failure() {
        return bLight_failure;
    }

    public void setbLight_failure(String bLight_failure) {
        this.bLight_failure = bLight_failure;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getRawString() {
        return rawString;
    }

    public void setRawString(String rawString) {
        this.rawString = rawString;
    }
}
