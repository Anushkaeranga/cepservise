package com.example.daoImpl;

import com.example.dao.BookDao;
import com.example.modle.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
  Created by Malitha on 6/22/2016.
 */
public class BookDaoImpl implements BookDao {

    Map<String, Book> bookmap = new HashMap<>();


    public BookDaoImpl() {
        Book bk = new Book();
        bk.setAuther("malitha");
        bk.setId("12312");
        bk.setIsbn("qwdqwdqwdqw");
        bk.setPublish("wffqw");
        bk.setTitle("jhvghfgh");
        bookmap.put("book1", bk);
        Book bk2 = new Book();
        bk2.setAuther("malitha");
        bk2.setId("12312");
        bk2.setIsbn("qwdqwdqwdqw");
        bk2.setPublish("wffqw");
        bk2.setTitle("jhvghfgh");
        bookmap.put("book2", bk2);


    }

    @Override
    public Book getBookS(String key) {

        return bookmap.get(key);
    }

    @Override
    public Collection<Book> getAllBookS() {
        return bookmap.values();
    }


}
