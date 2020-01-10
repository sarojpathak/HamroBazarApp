package com.saroj.hamrobazar.model;

import android.content.Intent;

public class User {
    private String fullName;
    private String username;
    private String password;
    private int phone;
    private int mobilePhone;
    private String street;
    private String area;
    private String city;
    private Boolean newsletter;
    private Boolean hidePhone;
    private Boolean agree;
    private String image;

    public User(String fullName, String username, String password, int phone, int mobilePhone, String street, String area, String city, Boolean newsletter, Boolean hidePhone, Boolean agree, String image) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.street = street;
        this.area = area;
        this.city = city;
        this.newsletter = newsletter;
        this.hidePhone = hidePhone;
        this.agree = agree;
        this.image = image;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(int mobilePhone) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
