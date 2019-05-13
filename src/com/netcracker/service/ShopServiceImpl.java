package com.netcracker.service;

import com.netcracker.dao.ShopDAO;
import com.netcracker.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopService")
public class ShopServiceImpl extends BaseServiceImpl<Shop> implements ShopService{

    @Autowired
    ShopDAO dao;

    public void saveShop(Shop object) {
        dao.save(object);
    }

    public void deleteShop(Shop object) {
        dao.deleteObject(object);
    }

    public List<String> getShopFromSormAndSov() {
        return dao.shopFromSormAndSov();
    }
}
