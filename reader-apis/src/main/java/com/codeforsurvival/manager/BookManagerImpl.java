package com.codeforsurvival.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codeforsurvival.db.entity.Book;
import com.codeforsurvival.db.entity.User;
import com.codeforsurvival.service.BookService;
import com.codeforsurvival.service.UserService;

@Component
public class BookManagerImpl implements BookManager {

	@Autowired
	private BookService bookService;

	public Book addBook(Book book) {
		return bookService.addBook(book);
	}

	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	public Book getBook(Long id) {
		return bookService.getBook(id);
	}

	public List<Book> getBooksByUserId(Long userId) {
		return bookService.getBooksByUserId(userId);
	}

	public List<Book> getBooksByStatus(Long userId, String status) {
		return bookService.getBooksByStatus(userId, status);
	}

}
