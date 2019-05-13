package com.netcracker.service;

import com.netcracker.model.Shop;

import java.util.List;

public interface ShopService extends BaseService<Shop>{

    void saveShop(Shop object);
    void deleteShop(Shop object);
    List<String> getShopFromSormAndSov();
}
