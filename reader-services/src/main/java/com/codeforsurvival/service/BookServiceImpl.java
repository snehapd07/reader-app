package com.codeforsurvival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codeforsurvival.db.dao.BookDao;
import com.codeforsurvival.db.entity.Book;

public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	public Book addBook(Book book) {
		return this.bookDao.addBook(book);
	}

	public List<Book> getAllBooks() {
		return this.bookDao.getAllBooks();
	}

	public Book getBook(Long id) {
		return this.bookDao.getBook(id);
	}

	public List<Book> getBooksByUserId(Long userId) {
		return this.bookDao.getBooksByUserId(userId);
	}

	public List<Book> getBooksByStatus(Long userId, String status) {
		return bookDao.getBooksByStatus(userId, status);
	}

}
