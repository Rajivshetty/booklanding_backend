package com.book.lending.util;

public class BookUtil {
	private BookUtil(){
	}
	

	public static final String CREDENTIALS_EMPTY = "UserName or Password cannot be empty";
	public static final String LOGIN_SUCCESS = "Logged In Successfully";
	public static final String LOGIN_FAILURE = "Incorrect Username or password";
	public static final Integer LOGIN_SUCCESS_CODE = 201;
	public static final Integer LOGIN_FAILURE_CODE = 401;
	public static final String BOOK_REQUEST_EXCEPTION = "Your Request Cannot Be Processed For the Book";
	public static final String BOOK_REQUEST_SUCCESS = "The Requested Book Is not Available We will get Back To you Once it is available";
	public static final Integer BOOK_REQUEST_SUCCESS_CODE = 201;
	public static final String BOOK_REQUEST_AVAILABLE = "AVAILABLE";
	public static final String BOOK_REQUEST_NOT_AVAILABLE = "NOT AVAILABLE";
	public static final String NO_BOOK_FOUND = "No Book Found With The Given Id";

	
	public static final String STATUS = "AVAILABLE";
	public static final String ADDBOOK = "ADDED SUCCESSFULLY";
	public static final String GETBOOKS = "GET BOOK LIST SUCCESSFULLY";
	
	public static final Integer BORROW_STATUS_CODE=201;
	public static final String BORROW_STATUS_MESSAGE="book issued successfully";
	public static final String BORROW_EXCEPTION_MESSAGE="Please Check the userId and bookId";
	
	public static final String REGISTER_SUCCESS = "Register Successfully";
	public static final String REGISTER_FAILURE = "Not registerd successfully";
	public static final String CATEGORY_TYPE = "Fiction";
	public static final String ADD_BOOK_FAILURE = "Added book exception";
	public static final String INDIAN_TIME_ZONE="Asia/Kolkata";

}
