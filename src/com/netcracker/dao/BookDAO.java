
package com.netcracker.dao;

import com.netcracker.model.Book;


import java.util.List;

public interface BookDAO extends BaseDAO<Book>{

    public List<String> findAllTitle();
    public List<Integer> findAllCost();
    public List<String> findSpecialBook();
    //void updateById(int id, Book object);
}

