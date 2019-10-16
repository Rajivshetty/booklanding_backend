package com.book.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.lending.entity.BookRequest;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequest, Integer> {

}
