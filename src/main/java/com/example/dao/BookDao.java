package com.example.dao;

import com.example.modle.Book;

import java.util.Collection;


/*
  Created by Malitha on 6/22/2016.
 */
public interface BookDao {

     Book getBookS(String key);

     Collection<Book> getAllBookS();


}
