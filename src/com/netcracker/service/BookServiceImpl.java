
package com.netcracker.service;

import com.netcracker.dao.BookDAO;
import com.netcracker.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService{

    @Autowired
    BookDAO dao;

    public void saveBook(Book object) {
        dao.save(object);
    }

    public void deleteBook(Book object) {
        dao.deleteObject(object);
    }

    public List<String> getAllTitle() {
        return dao.findAllTitle();
    }

    public List<Integer> getAllCost(){return dao.findAllCost();}

    public List<String> getSpecialBook(){return dao.findSpecialBook(); }
    /*public void updateById(int id, Book object) {
        dao.updateById(id,object);
    }*/
}

