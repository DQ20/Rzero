package com.Husky.superMarket.serviceImpl;

import com.Husky.superMarket.DAO.CartGoodsDao;
import com.Husky.superMarket.DAO.fruitDao;
import com.Husky.superMarket.DAO.stationaryDao;
import com.Husky.superMarket.DAOImpl.CartGoodsImpl;
import com.Husky.superMarket.DAOImpl.fruitImpl;
import com.Husky.superMarket.DAOImpl.stationaryImpl;
import com.Husky.superMarket.pojo.CartGoods;
import com.Husky.superMarket.pojo.Fruit;
import com.Husky.superMarket.pojo.stationary;
import com.Husky.superMarket.service.cartService;

public class cartGoodsServiceImpl implements cartService {
    CartGoodsDao cg=new CartGoodsImpl();
    fruitDao fd=new fruitImpl();
    stationaryDao sd=new stationaryImpl();
    @Override
    public void deleteGoods(String name) {
        Fruit fruit=fd.check(name);
        stationary stn=sd.check(name);
        if (fruit.getName() != null) {
            int num=fruit.getNum();
            num+=1;
            fruit.setNum(num);
            fd.mdFr(fruit);
        }
        else if(stn.getName()!=null){
            int num=fruit.getNum();
            num+=1;
            stn.setNum(num);
            sd.mdSt(stn);
        }
        cg.delC(name);
    }

    @Override
    public void addGoods(String name) {
        Fruit fruit=fd.check(name);
        stationary stn=sd.check(name);
        if (fruit.getName() != null) {
            int num=fruit.getNum();
            num-=1;
            fruit.setNum(num);
            fd.mdFr(fruit);
            double price=fruit.getPrice();
            CartGoods ca=new CartGoods();
            ca.setName(name);
            ca.setNum(1);
            ca.setPrice(price);
            cg.add(ca);
        }
        else if(stn.getName()!=null){
            int num=stn.getNum();
            num-=1;
            stn.setNum(num);
            sd.mdSt(stn);
            double price=stn.getPrice();
            CartGoods ca=new CartGoods();
            ca.setName(name);
            ca.setNum(1);
            ca.setPrice(price);
            cg.add(ca);
        }

    }
    @Override
    public void A(String name) {
        CartGoods ca=cg.check(name);
        int num=ca.getNum();
        num+=1;
        ca.setNum(num);
        cg.modifyC(ca);
    }

    @Override
    public void B(String name) {
        CartGoods ca=cg.check(name);
        int num=ca.getNum();
        num-=1;
        ca.setNum(num);
        cg.modifyC(ca);
    }

    @Override
    public CartGoods check(String name) {
        return cg.check(name);
    }

}
