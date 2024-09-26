package com.mehtab.test1.Service;

import java.util.Map;

import com.mehtab.test1.Model.Book;

public interface BookService {   
    Map<Integer, Book> getBooks();
    Book getBookById(int id);
    Book saveBook(Book book);
    String deleteBook(int id);
    Book updateBook(int id, Book book);
}
