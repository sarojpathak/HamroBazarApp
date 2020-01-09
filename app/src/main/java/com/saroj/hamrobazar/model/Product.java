package com.saroj.hamrobazar.model;

import java.sql.Array;

public class Product {
    private String name;
    private Integer price;
    private Array type;

    public Product(String name, Integer price, Array type) {
        this.name = name;
        this.price = price;
        this.type = type;
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

    public Array getType() {
        return type;
    }

    public void setType(Array type) {
        this.type = type;
    }
}
