package com.Husky.superMarket.DAO;

import com.Husky.superMarket.pojo.CartGoods;

import java.util.List;

public interface CartGoodsDao {
    void delC(String name);
    List<CartGoods> checkAll();
    void add(CartGoods goods);
    void delAll();
    CartGoods check(String name);

    void modifyC(CartGoods cartGoods);
}
