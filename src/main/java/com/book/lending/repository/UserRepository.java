/**
 * 
 */
package com.book.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.lending.entity.User;

/**
 * @author User1
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{

}
