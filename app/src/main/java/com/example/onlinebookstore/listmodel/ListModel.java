package com.example.onlinebookstore.listmodel;

import android.widget.Button;

public class ListModel {

    private  int imgId;
    private  String name;
    private  String price;
    private  String category;

    public ListModel(int imgId, String name, String price,String category) {
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
