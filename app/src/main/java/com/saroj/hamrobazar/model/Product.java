package com.saroj.hamrobazar.model;

import java.sql.Array;

public class Product {
    private String name;
    private Integer price;
    private String type;
    private Boolean popular;
    private Integer image;

    public Product(String name, Integer price, String type, Boolean popular, Integer image) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
