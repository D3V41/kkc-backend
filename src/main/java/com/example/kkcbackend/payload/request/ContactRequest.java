package com.example.kkcbackend.payload.request;

import com.sun.istack.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ContactRequest {
    @NotNull
    private Long id;
    @NotNull
    private String personName;
    @NotNull
    private Long personMobile;
    @NotNull
    private String address;
    @NotNull
    private String ulbName;

    public ContactRequest(Long id, String personName, Long personMobile, String address, String ulbName) {
        this.id = id;
        this.personName = personName;
        this.personMobile = personMobile;
        this.address = address;
        this.ulbName = ulbName;
    }

    public ContactRequest(String personName, Long personMobile, String address, String ulbName) {
        this.personName = personName;
        this.personMobile = personMobile;
        this.address = address;
        this.ulbName = ulbName;
    }

    public ContactRequest() {
    }

    public String getUlbName() {
        return ulbName;
    }

    public void setUlbName(String ulbName) {
        this.ulbName = ulbName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Long getPersonMobile() {
        return personMobile;
    }

    public void setPersonMobile(Long personMobile) {
        this.personMobile = personMobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
