package com.dx9.example;

public class Car {

    private int price;
    private String colour;
    private String model;

    public Car(String model, String colour, int price) {
        this.model = model;
        this.colour = colour;
        this.price = price;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
