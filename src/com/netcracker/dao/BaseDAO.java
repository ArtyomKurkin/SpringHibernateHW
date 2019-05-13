package com.netcracker.dao;

import java.util.List;

public interface BaseDAO<T> {

    void save(T object);
    void deleteObject(T object);
    List<T> getAll();
    Long countRow();
    T findById(int id);
    void deleteById(int id);
    void updateById(int id, T object);


}
