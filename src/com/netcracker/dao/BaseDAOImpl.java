package com.netcracker.dao;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//@Repository("baseDAO")
@Transactional
public class BaseDAOImpl<T>{


    @Autowired
    public Class<T> typeClass;

    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    protected void persist(Object object){
        getSession().persist(object);
    }

    protected void delete(Object object){
        getSession().delete(object);

    }

    public  void save(T object){
        persist(object);
    }

    public
    void deleteObject(T object){
        delete(object);
    }

    public List<T> getAll(){
        Criteria criteria = getSession().createCriteria(typeClass);
        return criteria.list();
    }

    public Long countRow(){
        Query query = getSession().createQuery(new String("select count(*) from " + typeClass.getName()));
        return (Long)query.uniqueResult();
    }

    public T findById(int id){
        Criteria criteria = getSession().createCriteria(typeClass);
        criteria.add(Restrictions.eq("id",id));
        return (T) criteria.uniqueResult();
    }

    public void deleteById(int id) {
        Query query = getSession().createQuery(new String("delete from "+typeClass.getName()+" where id = :id"));
        query.setInteger("id",id);
        query.executeUpdate();
    }


}
