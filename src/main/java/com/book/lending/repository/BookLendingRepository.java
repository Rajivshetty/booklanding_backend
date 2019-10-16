/**
 * 
 */
package com.book.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.lending.entity.BookLending;

/**
 * @author User1
 *
 */

@Repository
public interface BookLendingRepository extends JpaRepository<BookLending, Integer>{

}
