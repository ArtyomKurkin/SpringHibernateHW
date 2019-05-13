package com.netcracker.dao;

import com.netcracker.model.Purchase;

import java.util.List;

public interface PurchaseDAO extends BaseDAO<Purchase> {

    List<Integer> getAllMonths();
    List<String> getInfo();
    List<String> getFullInfo();
    List<String> topPurchase();
    void updateById(int id, Purchase object);
    List<String> latePurchase();
    List<String> specialShop();
    List<String> specialPurchase();
}
