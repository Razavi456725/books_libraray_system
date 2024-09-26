package com.mehtab.test1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehtab.test1.Entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{
    
    // Perform crud operation , find by id
    // you can customise
}
