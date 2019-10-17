package com.book.lending.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer bookId;
	private Integer userId;

}
