package com.example.javamadeeasy.models;

public class Menu {

    String name;
    Integer color;
    Integer image;

    public Menu(String name, Integer color, Integer image) {
        this.name = name;
        this.color = color;
        this.image = image;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getColor(){
        return  color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getImage(){
        return  image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

}
