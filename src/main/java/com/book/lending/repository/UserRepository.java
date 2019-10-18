
package com.book.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.lending.entity.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;
/**
 * @author shiva
 *
 */


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByUserEmailAndPassword(String userEmail, String password);


}
