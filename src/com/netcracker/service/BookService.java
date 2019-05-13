
package com.netcracker.service;

import com.netcracker.model.Book;

import java.util.List;

public interface BookService extends BaseService<Book>{
    void saveBook(Book object);
    void deleteBook(Book object);
    List<String> getAllTitle();
    List<Integer> getAllCost();
    List<String> getSpecialBook();

}

