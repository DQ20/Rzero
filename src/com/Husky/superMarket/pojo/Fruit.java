package com.Husky.superMarket.pojo;

import java.sql.Date;
import java.util.Objects;

public class Fruit {
    private String name;
    private double price;
    private int num;
    private Date productionDate;
    private int PreservationPeriod;
    private String Unit;

    public Fruit(String name, double price, int num, Date productionDate, int preservationPeriod, String unit) {
        this.name = name;
        this.price = price;
        this.num = num;
        this.productionDate = productionDate;
        PreservationPeriod = preservationPeriod;
        Unit = unit;
    }

    public Fruit() {
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

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public int getPreservationPeriod() {
        return PreservationPeriod;
    }

    public void setPreservationPeriod(int preservationPeriod) {
        PreservationPeriod = preservationPeriod;
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
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.price, price) == 0 && num == fruit.num && Objects.equals(name, fruit.name) && Objects.equals(productionDate, fruit.productionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, num, productionDate);
    }
}
