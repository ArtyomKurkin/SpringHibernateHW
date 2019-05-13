package com.netcracker.service;

import com.netcracker.model.Purchase;

import java.util.List;

public interface PurchaseService extends BaseService<Purchase> {
    void savePurchase(Purchase object);
    void deletePurchase(Purchase object);
    List<Integer> getAllMonths();
    List<String> getInfo();
    List<String> getFullInfo();
    List<String> getTopPurchases();
    List<String> getLatePurchases();
    List<String> getSpecialShops();
    List<String> getSpecialPurchases();

}
