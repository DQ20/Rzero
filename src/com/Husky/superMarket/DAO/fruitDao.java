package com.Husky.superMarket.DAO;

import com.Husky.superMarket.pojo.Fruit;

import java.util.List;

public interface fruitDao {
    List<Fruit> AllFruit();
    List<Fruit> LikeSC(String ipName);
    void RemoveFr(String name);
    void addFr(Fruit fr);
    void mdFr(Fruit fr);
    Fruit check(String name);
}
