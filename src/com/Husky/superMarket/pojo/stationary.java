package com.Husky.superMarket.pojo;

import javax.xml.crypto.Data;
import java.util.Objects;

public class stationary {
    private String name;
    private double price;
    private int num;
    private String ProductPlace;
    private String Unit;

    public stationary(String name, double price, int num, String productPlace, String unit) {
        this.name = name;
        this.price = price;
        this.num = num;
        ProductPlace = productPlace;
        Unit = unit;
    }

    public stationary() {
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

    public String getProductPlace() {
        return ProductPlace;
    }

    public void setProductPlace(String productPlace) {
        ProductPlace = productPlace;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        stationary that = (stationary) o;
        return Double.compare(that.price, price) == 0 && num == that.num && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, num);
    }
}
