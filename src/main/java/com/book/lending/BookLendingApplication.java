package com.book.lending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookLendingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookLendingApplication.class, args);
	}

}
