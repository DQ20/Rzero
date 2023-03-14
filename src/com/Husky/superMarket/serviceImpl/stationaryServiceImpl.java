package com.Husky.superMarket.serviceImpl;

import com.Husky.superMarket.DAO.stationaryDao;
import com.Husky.superMarket.DAOImpl.stationaryImpl;
import com.Husky.superMarket.pojo.stationary;
import com.Husky.superMarket.service.stationaryService;

import java.util.ArrayList;
import java.util.List;

public class stationaryServiceImpl implements stationaryService {
    stationaryDao sd=new stationaryImpl();
    List<stationary> list=new ArrayList<>();
    @Override
    public List<stationary> checkSt(String ipName) {
        list=sd.LikeSC(ipName);
        return list;
    }

    @Override
    public void deleteSt(String name) {
        sd.RemoveSt(name);
    }

    @Override
    public void addSt(stationary st) {
        sd.addSt(st);
    }

    @Override
    public void modifyst(stationary st) {
        sd.mdSt(st);
    }
}
