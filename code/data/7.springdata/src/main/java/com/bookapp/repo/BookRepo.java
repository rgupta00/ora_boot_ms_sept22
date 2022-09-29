package com.bookapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	public List<Book> findByTitle(String title);

	@Query("select b from Book b")
	public List<Book> getallbooks();
}
