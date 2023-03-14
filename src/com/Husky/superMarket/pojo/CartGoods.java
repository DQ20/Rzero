package com.Husky.superMarket.pojo;

public class CartGoods {
    private String name;
    private double price;
    private int num;

    public CartGoods(String name, double price, int num) {
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public CartGoods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
