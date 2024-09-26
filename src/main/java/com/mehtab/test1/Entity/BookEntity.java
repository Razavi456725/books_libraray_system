package com.mehtab.test1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Entity -> it use to store data into database  // DAO Layer

@Entity         //table is automatically created (object mapped with table column )
public class BookEntity {
    @Id
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
