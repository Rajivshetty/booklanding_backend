package com.book.lending.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.lending.entity.User;

/**
 * @author User1
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByUserEmailAndPassword(String userEmail, String password);


}
