package com.netcracker.service;

import com.netcracker.model.Customer;

import java.util.List;

public interface CustomerService extends BaseService<Customer>{
    void saveCustomer(Customer object);
    void deleteCustomer(Customer object);
    List<String> getAllDist();
    List<String> getCustomFromNizh();

}
