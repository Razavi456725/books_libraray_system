package com.mehtab.test1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mehtab.test1.Entity.BookEntity;
import com.mehtab.test1.Model.Book;
import com.mehtab.test1.Repository.BookRepository;

@Service
public class BookServiceImpl2 implements BookService2{
   // object creation - by Spring ioc and | dependency injection causes of autowiring
    BookRepository bookRepository;   // object created of Book Repository class 

     // Constructor Dependency injection
    BookServiceImpl2(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }


    @Override
    public ResponseEntity<?> getBooks() {
       // type conversion from entity to model (data to object)
        List<Book> books=new ArrayList<>();   // DTO--> Data Transfer Object 
        List<BookEntity> booksDb = bookRepository.findAll(); // DAO--> Data Access Object
        for (BookEntity bookEntity : booksDb) {
            Book book = new Book();
            BeanUtils.copyProperties(bookEntity, book); // data transfer from book entity to book
            books.add(book);
        }
        if(books.isEmpty()){
            String str="please first add the book";
            return ResponseEntity.badRequest().body(str);
        }
        else {
            return ResponseEntity.ok().body(books);
        }
    }

    @Override
    public Book getBookById(int id) {
        BookEntity bookEntity= bookRepository.findById(id).get();
        Book book = new Book();

        BeanUtils.copyProperties(bookEntity, book);  // data copy from book_Entity class(Entity) and store into book_class(Model)
        return book;
    }

    @Override
    public Book saveBook(Book book) {
        BookEntity bookEntity= new BookEntity();
        BeanUtils.copyProperties(book, bookEntity);// Data copy from book and store into bookEntity
        bookRepository.save(bookEntity);
        return book;

    }

    @Override
    public String deleteBook(int id) {
        BookEntity bookEntity= bookRepository.findById(id).get();
        bookRepository.delete(bookEntity);
        return "Delete Sucessfully";
    }

    @Override
    public Book updateBook(int id, Book book) {
       // check if book is exist
        BookEntity bookEntity= bookRepository.findById(id).get();  

        // update the privious values in entity
        if (bookEntity != null && bookEntity.getId() == book.getId()) {
            // update the previous values in entity
            bookEntity.setAuthor(book.getAuthor());
            bookEntity.setTitle(book.getTitle());

            // update into database
            bookRepository.save(bookEntity);
            return book;
        } else {
            // throw an exception or return an error message if the book ID doesn't match
            throw new RuntimeException("Book ID mismatch");
        }

    }
    
}
