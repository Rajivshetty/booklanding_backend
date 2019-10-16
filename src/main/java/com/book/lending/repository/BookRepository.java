/**
 * 
 */
package com.book.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.lending.entity.Book;

/**
 * @author User1
 *
 */
public interface BookRepository extends JpaRepository<Book, Integer>{

}
