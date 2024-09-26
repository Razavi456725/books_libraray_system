package com.mehtab.test1.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mehtab.test1.Model.Book;
import com.mehtab.test1.Service.BookService;
import com.mehtab.test1.Service.BookService2;
import com.mehtab.test1.Service.BookServiceImpl;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController  // call (request) receive from the client | call forward to service | whatever service provided by service provider give response to the client
@RequestMapping("books/v3")  
public class BookControllerV3{

 // object creation - by Spring ioc and | dependency injection causes of autowiring
  BookService2 bookService;
  BookControllerV3(BookService2 bookService){  // to avoid null object exception that's why we make constructor
    this.bookService=bookService;
  }

  @GetMapping    
    public ResponseEntity<?> getAllBooks(){  // get all book
        return bookService.getBooks();  
    }

    @GetMapping("/{id}")      
    public Book readBookById(@PathVariable int id){  // get book by id
        return bookService.getBookById(id); 
    }

    @PostMapping             
    public Book createBook(@RequestBody Book book){
      
        return bookService.saveBook(book);  //call Forwading
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updateBook){

        return bookService.updateBook(id, updateBook);
     }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
       return bookService.deleteBook(id);
    }

    




    
}
