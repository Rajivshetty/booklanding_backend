package com.book.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.lending.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
