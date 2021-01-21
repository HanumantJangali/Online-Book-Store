package com.example.onlinebookstore.horizontalmodel;

public class HorizontalModel {
    private int imgId;
    private String name;
    private String price;
    private String category;

    public HorizontalModel(int imgId, String name, String price, String category) {
        this.imgId = imgId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}



