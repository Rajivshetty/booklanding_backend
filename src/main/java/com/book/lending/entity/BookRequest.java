package com.book.lending.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="BookRequest")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookRequestId;
	private Integer bookId;
	private LocalDate requestDate;
	private Integer userId;
	/**
	 * @return the bookRequestId
	 */
	public Integer getBookRequestId() {
		return bookRequestId;
	}
	/**
	 * @param bookRequestId the bookRequestId to set
	 */
	public void setBookRequestId(Integer bookRequestId) {
		this.bookRequestId = bookRequestId;
	}
	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the requestDate
	 */
	public LocalDate getRequestDate() {
		return requestDate;
	}
	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
