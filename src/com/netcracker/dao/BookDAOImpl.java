
package com.netcracker.dao;

import com.netcracker.model.Book;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;



@Repository("bookDAO")
@Transactional
public class BookDAOImpl extends BaseDAOImpl<Book> implements BookDAO{
    public List<String> findAllTitle() {
        Query query = getSession().createQuery("select distinct title from Book");
        return (List<String>)query.list();
    }

    public List<Integer> findAllCost() {
        Query query = getSession().createQuery("select distinct cost from Book");
        return (List<Integer>)query.list();
    }

    public List<String> findSpecialBook() {
        String param = "%Windows%";
        Query query = getSession().createQuery(new String("from Book where (cost>'20000') or title like '"+param+"' order by cost desc"));
        List<String> result = new ArrayList<String>();
        for (Book book : (List<Book>)query.list()){
            String row = "Title: " + book.getTitle() +", Cost: " + book.getCost();
            result.add(row);
        }
        return result;
    }

    public void updateById(int id, Book book){
        Query query = getSession().createQuery("UPDATE Book set title = :title, cost = :cost,storage = :storage, count = :count WHERE id = :id");
        query.setInteger("id", id);
        query.setString("title",book.getTitle());
        query.setInteger("cost",book.getCost());
        query.setString("storage",book.getStorage());
        query.setInteger("count",book.getCount());
        query.executeUpdate();
    }
}

