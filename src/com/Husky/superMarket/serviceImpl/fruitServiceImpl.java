package com.Husky.superMarket.serviceImpl;

import com.Husky.superMarket.DAO.fruitDao;
import com.Husky.superMarket.DAOImpl.fruitImpl;
import com.Husky.superMarket.pojo.Fruit;
import com.Husky.superMarket.service.fruitService;

import java.util.ArrayList;
import java.util.List;

public class fruitServiceImpl implements fruitService
{

    fruitDao fd=new fruitImpl();
    List<Fruit> list=new ArrayList<>();
    @Override
    public List<Fruit> checkFruit(String ipName) {
        list=fd.LikeSC(ipName);
        return list;
    }

    @Override
    public void deleteFruit(String name) {
        fd.RemoveFr(name);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fd.addFr(fruit);
    }

    @Override
    public void modifyFruit(Fruit fruit) {
        fd.mdFr(fruit);
    }
}
