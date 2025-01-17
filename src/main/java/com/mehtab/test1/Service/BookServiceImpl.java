package com.mehtab.test1.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mehtab.test1.Model.Book;


@Service
public class BookServiceImpl implements BookService{
    
    private Map<Integer,Book> booksMap = new HashMap<>();
    private int bookId = 1;
    
    @Override
    public Map<Integer, Book> getBooks() {
        return booksMap;
        
    }

    @Override
    public Book getBookById(int id) {
        return booksMap.get(id); 
       
    }

    @Override
    public Book saveBook(Book book) {
        book.setId(generateNextId());
        booksMap.put(book.getId(), book);
        return book;
    }

    @Override
    public String deleteBook(int id) {
        if(booksMap.get(id)==null)
        return "Book Not Found";
        booksMap.remove(id);
      
        return "Delete Sucessfully";
    }

    @Override
    public Book updateBook(int id, Book updateBook) {
        Book existingBook = booksMap.get(id);
        if(updateBook.getTitle()!=null)
        {
           existingBook.setTitle(updateBook.getTitle());
            existingBook.setAuthor(updateBook.getAuthor());
        }

         return existingBook;
       
    }
    private int generateNextId()
    {
        return bookId++;
    }
    
}
