package com.book.lending.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.lending.entity.Book;

/**
 * @author User1
 *
 */

/**
 * @author User1
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	public Optional<Book> findByBookIdAndStatus(Integer bookId, String status);

	public List<Book> findAllByOrderByBookName();

}
