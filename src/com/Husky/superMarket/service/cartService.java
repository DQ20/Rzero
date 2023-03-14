package com.Husky.superMarket.service;

import com.Husky.superMarket.DAO.CartGoodsDao;
import com.Husky.superMarket.DAOImpl.CartGoodsImpl;
import com.Husky.superMarket.pojo.CartGoods;

import java.util.ArrayList;
import java.util.List;

public interface cartService {

    void deleteGoods(String name);
    void addGoods(String name);
    static List<CartGoods> allGoods(){
        List<CartGoods> list=new ArrayList<>();
        CartGoodsDao cg=new CartGoodsImpl();
        list=cg.checkAll();
        return list;
    }
    void A(String name);
    void B(String name);
    static void clear(){
        CartGoodsDao cg=new CartGoodsImpl();
        cg.delAll();
    }
    CartGoods check(String name);
}
