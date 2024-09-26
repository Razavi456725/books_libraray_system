package com.mehtab.test1.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mehtab.test1.Service.BookServiceImpl;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController  // call (request) receive from the client | call forward to service | whatever service provided by service provider give response to the client
@RequestMapping("books")  
public class BookController{

    // object creation -- by jvm & programmer
   // BookService bookService = new BookServiceImpl();
   
   // object creation - by Spring ioc and | dependency injection causes of autowiring
  @Autowired
   BookService bookService;

    @GetMapping
    public Map getAllBooks(){  // get all book  (call getBooks() method)
        return bookService.getBooks();  // whatever book are stored in map return here| call forwarding
    }

    @GetMapping("/{id}")      
    public Book readBookById(@PathVariable int id){  // get book by id
        return bookService.getBookById(id);  // whatever book are stored in map return here 
        // handle the edge case if book is not found   (call getBookById() method )
    }

    @PostMapping             
    public Book createBook(@RequestBody Book book){  // library
      
        return bookService.saveBook(book);  // person (call saveBook() method)
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updateBook){
       
        return bookService.updateBook(id, updateBook); // call updateBook() method
     }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
       return bookService.deleteBook(id);  // Call deleteBook() method
    }

    




    
}
