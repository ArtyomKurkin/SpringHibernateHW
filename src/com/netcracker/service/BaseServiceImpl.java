package com.netcracker.service;

import com.netcracker.dao.BaseDAO;
import com.netcracker.dao.BaseDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T>{
    @Autowired
    BaseDAO<T> dao;



    public T findById(int id){
        return dao.findById(id);
    }

   public void updateById(int id, T object) {
        dao.updateById(id,object);
    }

    public List<T> getAll() {
       return dao.getAll();
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public Long countRow() {
        return dao.countRow();
    }

}
