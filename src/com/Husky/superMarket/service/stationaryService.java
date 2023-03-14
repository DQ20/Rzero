package com.Husky.superMarket.service;

import com.Husky.superMarket.DAO.stationaryDao;
import com.Husky.superMarket.DAOImpl.fruitImpl;
import com.Husky.superMarket.DAOImpl.stationaryImpl;
import com.Husky.superMarket.pojo.Fruit;
import com.Husky.superMarket.pojo.stationary;

import java.util.List;

public interface stationaryService {
    stationary sn=new stationary();
    stationaryDao sd=new stationaryImpl();
    static List<stationary> allFruit(){
        List<stationary>  list=sd.AllSt();
        return list;
    }
    List<stationary> checkSt(String ipName);
    void deleteSt(String name);
    void addSt(stationary st);
    void modifyst(stationary st);
}
