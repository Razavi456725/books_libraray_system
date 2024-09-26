package com.mehtab.test1.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mehtab.test1.Model.Book;

public interface BookService2 {   
    ResponseEntity<?> getBooks();
    Book getBookById(int id);
    Book saveBook(Book book);
    String deleteBook(int id);
    Book updateBook(int id, Book book);
}
