package com.saroj.hamrobazar.model;

import android.content.Intent;

public class User {
    private String fullName;
    private String email;
    private String password;
    private Integer phone;
    private Intent mobilePhone;
    private String street;
    private String area;
    private String city;
    private Boolean newsletter;
    private Boolean hidePhone;
    private Boolean agree;

    public User(String fullName, String email, String password, Integer phone, Intent mobilePhone, String street, String area, String city, Boolean newsletter, Boolean hidePhone, Boolean agree) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.street = street;
        this.area = area;
        this.city = city;
        this.newsletter = newsletter;
        this.hidePhone = hidePhone;
        this.agree = agree;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Intent getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Intent mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    public Boolean getHidePhone() {
        return hidePhone;
    }

    public void setHidePhone(Boolean hidePhone) {
        this.hidePhone = hidePhone;
    }

    public Boolean getAgree() {
        return agree;
    }

    public void setAgree(Boolean agree) {
        this.agree = agree;
    }
}
