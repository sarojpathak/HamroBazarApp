package com.saroj.hamrobazar.activities;

public class ListedAds {

    private String adName;
    private  String Adprice;
    private  int imagesId;
    private  String Producttype;

    public ListedAds(String adName, String adprice, int imagesId, String producttype) {
        this.adName = adName;
        Adprice = adprice;
        this.imagesId = imagesId;
        Producttype = producttype;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdprice() {
        return Adprice;
    }

    public void setAdprice(String adprice) {
        Adprice = adprice;
    }

    public int getImagesId() {
        return imagesId;
    }

    public void setImagesId(int imagesId) {
        this.imagesId = imagesId;
    }

    public String getProducttype() {
        return Producttype;
    }

    public void setProducttype(String producttype) {
        Producttype = producttype;
    }
}
