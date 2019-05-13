package com.netcracker.dao;

import com.netcracker.model.Shop;

import java.util.List;

public interface ShopDAO extends BaseDAO<Shop>{

    List<String> shopFromSormAndSov();
    void updateById(int id, Shop object);
}
