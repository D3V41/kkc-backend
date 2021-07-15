package com.example.kkcbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="contacts")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String personName;

    @NotNull
    private Long personMobile;

    @NotNull
    private String address;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "ulb_id",nullable = false)
    private Ulb ulb;

    public Contact(Long id, String personName, Long personMobile, String address, Ulb ulb) {
        this.id = id;
        this.personName = personName;
        this.personMobile = personMobile;
        this.address = address;
        this.ulb = ulb;
    }

    public Contact(String personName, Long personMobile, String address, Ulb ulb) {
        this.personName = personName;
        this.personMobile = personMobile;
        this.address = address;
        this.ulb = ulb;
    }

    public Contact() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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



    public Ulb getUlb() {
        return ulb;
    }

    public void setUlb(Ulb ulb) {
        this.ulb = ulb;
    }
}
