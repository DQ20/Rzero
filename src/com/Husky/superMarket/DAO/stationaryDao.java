package com.Husky.superMarket.DAO;

import com.Husky.superMarket.pojo.Fruit;
import com.Husky.superMarket.pojo.stationary;

import java.util.List;

public interface stationaryDao {
    List<stationary> AllSt();
    List<stationary> LikeSC(String ipName);
    void RemoveSt(String name);
    void addSt(stationary st);
    void mdSt(stationary st);
    stationary check(String name);
}
