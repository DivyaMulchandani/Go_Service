package com.example.mad_project2;

public class DataModel {
    private String name;
    private double price;

    public void Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

