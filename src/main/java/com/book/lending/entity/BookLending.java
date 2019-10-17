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
@Table(name = "BookLending")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookLending {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookLendingId;
	private Integer bookId;
	private Integer userId;
	private LocalDate issuedDate;
	private LocalDate submissionDate;
	/**
	 * @return the bookLendingId
	 */
	public Integer getBookLendingId() {
		return bookLendingId;
	}
	/**
	 * @param bookLendingId the bookLendingId to set
	 */
	public void setBookLendingId(Integer bookLendingId) {
		this.bookLendingId = bookLendingId;
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
	/**
	 * @return the issuedDate
	 */
	public LocalDate getIssuedDate() {
		return issuedDate;
	}
	/**
	 * @param issuedDate the issuedDate to set
	 */
	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}
	/**
	 * @return the submissionDate
	 */
	public LocalDate getSubmissionDate() {
		return submissionDate;
	}
	/**
	 * @param submissionDate the submissionDate to set
	 */
	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}
	
	
	

}
