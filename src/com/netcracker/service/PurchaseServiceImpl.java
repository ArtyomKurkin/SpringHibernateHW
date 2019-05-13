package com.netcracker.service;

import com.netcracker.dao.PurchaseDAO;
import com.netcracker.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("purchaseService")
public class PurchaseServiceImpl extends BaseServiceImpl<Purchase> implements PurchaseService {

    @Autowired
    PurchaseDAO dao;

    public void savePurchase(Purchase object) {
        dao.save(object);
    }

    public void deletePurchase(Purchase object) {
        dao.deleteObject(object);
    }

    public List<Integer> getAllMonths() {
        return dao.getAllMonths();
    }

    public List<String> getInfo() {
        return dao.getInfo();
    }

    public List<String> getFullInfo() {
        return dao.getFullInfo();
    }

    public List<String> getTopPurchases() {
        return dao.topPurchase();
    }

    public List<String> getLatePurchases() {
        return dao.latePurchase();
    }

    public List<String> getSpecialShops() {
        return dao.specialShop();
    }

    public List<String> getSpecialPurchases() {
        return dao.specialPurchase();
    }
}
