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
}
