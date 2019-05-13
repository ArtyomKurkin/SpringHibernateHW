package com.netcracker.dao;


import com.netcracker.model.Purchase;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

@Repository("purchaseDAO")
@Transactional
public class PurchaseDAOImpl extends BaseDAOImpl<Purchase> implements PurchaseDAO{


    public List<Integer> getAllMonths() {
        Query query = getSession().createQuery("select distinct date from Purchase");
        List<Integer> result = new ArrayList<Integer>();
        for(Date date :(List<Date>)query.list()){
            result.add(date.getMonth()+1);
        }
        return result;
    }

    public List<String> getInfo() {
        List<Purchase> pur = getAll();
        List<String> result = new ArrayList<String>();
        for(Purchase purchase: pur){
            String row = "Customer: " + purchase.getCustomer().getSurname() + ", Shop: " + purchase.getShop().getTitle();
            result.add(row);
        }
        return result;
    }

    public List<String> getFullInfo() {
        List<Purchase> pur = getAll();
        List<String> result = new ArrayList<String>();
        for(Purchase purchase: pur){
            String row = "Date: " + purchase.getDate()+  ", Customer: " + purchase.getCustomer().getSurname() + ", Discount: " + purchase.getCustomer().getDiscount()
                    +"%, Book: " + purchase.getBook().getTitle() + ", Number: " + purchase.getNumber();
            result.add(row);
        }
        return result;
    }

    public List<String> topPurchase() {
        Query query = getSession().createQuery("from Purchase where (total > '60000')");
        List<String> result = new ArrayList<String>();
        for(Purchase purchase : (List<Purchase>)query.list()){
            String row = "Id: " + purchase.getId() + ", Customer: " + purchase.getCustomer().getSurname() + ", Date: " + purchase.getDate();
            result.add(row);
        }
        return result;
    }


    public void updateById(int id, Purchase purchase){
        Query query = getSession().createQuery("update Purchase set date = :date, shop = :shop, customer = :customer, book = :book, number = :number, total = :total where id = :id");
        query.setInteger("id",id);
        query.setDate("date", purchase.getDate());
        query.setEntity("shop",purchase.getShop());
        query.setEntity("customer",purchase.getCustomer());
        query.setEntity("book",purchase.getBook());
        query.setInteger("number", purchase.getNumber());
        query.setInteger("total", purchase.getTotal());
        query.executeUpdate();

    }

    public List<String> latePurchase() {
        Query query = getSession().createQuery("select p.customer.surname,p.shop.title,p.date from Purchase as p join p.customer join p.shop " +
                "where p.customer.district=p.shop.district and p.date>'2018-3-1' order by p.date");

        List<Object[]> list = query.list();
        List<String> result = new ArrayList<String>();
        for (Object[] obj : list){
            String row="Customer: "+ obj[0].toString()+",Shop: " + obj[1].toString()+",Date: " +obj[2].toString();
            result.add(row);
        }

        return result;
    }

    public List<String> specialShop() {
        Query query = getSession().createQuery("select p.shop.title, p.shop.district from Purchase as p join p.customer join p.shop " +
                "where p.shop.district != 'Autozavodskiy' and p.customer.discount>=10 and p.customer.discount<=15");
        List<Object[]> list = query.list();
        List<String> result = new ArrayList<String>();
        for (Object[] obj: list){
            String row = "Shop: "+obj[0].toString()+ ", District: " + obj[1].toString();
            result.add(row);
        }
        return result;
    }

    public List<String> specialPurchase() {
        Query query = getSession().createQuery("select p.book.title, p.book.storage, p.book.count, p.book.cost " +
                "from Purchase as p join p.shop join p.book where p.book.count >10 and p.shop.district = p.book.storage " +
                "order by p.book.cost");
        List<Object[]> list = query.list();
        List<String> result = new ArrayList<String>();
        for (Object[] obj: list){
            String row = "Book: "+obj[0].toString()+ ", District: " + obj[1].toString() + ", Count: " + obj[2].toString()
                    +",Cost: "+obj[3].toString();
            result.add(row);
        }
        return result;
    }


}
