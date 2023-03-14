package com.Husky.superMarket.service;

import com.Husky.superMarket.DAO.fruitDao;
import com.Husky.superMarket.DAOImpl.fruitImpl;
import com.Husky.superMarket.pojo.Fruit;

import java.util.ArrayList;
import java.util.List;

public interface fruitService {
    Fruit fruit=new Fruit();
    fruitDao fi=new fruitImpl();
    static List<Fruit> allFruit(){
        List<Fruit>  list=fi.AllFruit();
        return list;
    }
    List<Fruit> checkFruit(String ipName);
    void deleteFruit(String name);
    void addFruit(Fruit fruit);
    void modifyFruit(Fruit fruit);
}
