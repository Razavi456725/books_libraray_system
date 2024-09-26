package com.mehtab.test1.Model;

// model -> it use in application life cycle  (Use to serve the data from database)
public class Book {
    private int id;
    private String title;
    private String author;
    
    // getter and setter

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    

    

}
