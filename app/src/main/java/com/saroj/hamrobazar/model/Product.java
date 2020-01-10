package com.saroj.hamrobazar.model;

import java.sql.Array;

public class Product {
    private String name;
    private int price;
    private String type;
    private Boolean popular;
    private String image;

    public Product(String name, int price, String type, Boolean popular, String image) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.popular = popular;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPopular() {
        return popular;
    }

    public void setPopular(Boolean popular) {
        this.popular = popular;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
