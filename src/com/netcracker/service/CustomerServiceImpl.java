package com.netcracker.service;

import com.netcracker.dao.CustomerDAO;
import com.netcracker.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {

    @Autowired
    CustomerDAO dao;
    public void saveCustomer(Customer object) {
        dao.save(object);
    }

    public void deleteCustomer(Customer object) {
        dao.deleteObject(object);
    }

    public List<String> getAllDist() {
        return dao.findAllDist();
    }

    public List<String> getCustomFromNizh() {
        return dao.customFromNizh();
    }
}
