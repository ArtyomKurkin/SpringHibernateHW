package com.netcracker.service;

import java.util.List;

public interface BaseService<T> {
    T findById(int id);
    void updateById(int Id, T object);
    List<T> getAll();
    void deleteById(int id);
    Long countRow();
}
