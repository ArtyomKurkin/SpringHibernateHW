package com.netcracker.dao;

import com.netcracker.model.Customer;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl extends BaseDAOImpl<Customer> implements CustomerDAO {
    public List<String> findAllDist() {
        Query query = getSession().createQuery("select distinct district from Customer");
        return (List<String>)query.list();
    }

    public List<String> customFromNizh() {
        Query query = getSession().createQuery("from Customer where district = :district");
        query.setString("district","Nizhegorodskiy");
        List<String> result = new ArrayList<String>();
        for(Customer cust : (List<Customer>)query.list()){
            String row = "Surname: " + cust.getSurname() +", discount: " + cust.getDiscount();
            result.add(row);
        }
        return result;
    }

    public void updateById(int id, Customer customer){
        Query query = getSession().createQuery("update Customer set surname = :surname, district = :district, discount = :discount where id = :id");
        query.setInteger("id",id);
        query.setString("surname", customer.getSurname());
        query.setString("district", customer.getDistrict());
        query.setInteger("discount", customer.getDiscount());
        query.executeUpdate();
    }
}
