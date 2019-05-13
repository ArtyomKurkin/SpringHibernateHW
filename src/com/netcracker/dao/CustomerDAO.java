package com.netcracker.dao;

import com.netcracker.model.Customer;

import java.util.List;

public interface CustomerDAO extends BaseDAO<Customer>{
    public List<String> findAllDist();
    public List<String> customFromNizh();
    void updateById(int id, Customer object);

}
