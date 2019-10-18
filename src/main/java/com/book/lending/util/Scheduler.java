package com.book.lending.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.book.lending.entity.Book;
import com.book.lending.entity.BookLending;
import com.book.lending.repository.BookLendingRepository;
import com.book.lending.repository.BookRepository;

import static com.book.lending.util.BookUtil.*;

@Component
public class Scheduler {

	@Autowired
	BookLendingRepository bookLendingRepository;

	@Autowired
	BookRepository bookRepository;

	@Scheduled(fixedRate = 60000)
	public void statusUpdate() {
		LocalDate submissionDate = LocalDate.now(ZoneId.of(INDIAN_TIME_ZONE));

		List<BookLending> optBookLending = bookLendingRepository.findBySubmissionDate(submissionDate);
		List<Book> bookList = new ArrayList<>();

		optBookLending.stream().forEach(bookLending -> {
			Integer bookId = bookLending.getBookId();

			Optional<Book> optBook = bookRepository.findById(bookId);
			Book book = optBook.get();
			book.setStatus(BOOK_REQUEST_AVAILABLE);
			bookList.add(book);
		});
		bookRepository.saveAll(bookList);

	}

}
