package com.example.smartfarmer;

public class Product {
    int image;
    String name,price,type;

    public Product(int image, String name, String price, String type) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.type = type;
    }
    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
}
