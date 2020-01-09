package com.saroj.hamrobazar.model;

import java.sql.Array;

public class Product {
    private String name;
    private Integer price;
    private String type;
    private Boolean popular;
    private String image;

    public Product(String name, Integer price, String type, Boolean popular, String image) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.popular = popular;
        this.image = image;
    }


}
