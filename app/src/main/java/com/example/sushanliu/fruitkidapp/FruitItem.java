package com.example.sushanliu.fruitkidapp;

public class FruitItem {
    String name;
    int image;

    public FruitItem(String name, int image){
        this.name = name;
        this.image = image;
    }

    public String getName(){
        return name;
    }

    public int getImage() {
        return image;
    }
}
