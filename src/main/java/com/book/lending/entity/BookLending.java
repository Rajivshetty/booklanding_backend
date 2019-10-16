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

}
