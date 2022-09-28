package com.bookapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.entity.Book;
@Repository
public interface BookRepo  extends JpaRepository<Book, Integer>{

}
