package com.codeforsurvival.manager;

import java.util.List;

import com.codeforsurvival.db.entity.Book;

public interface BookManager {

	public Book addBook(Book book);

	public List<Book> getAllBooks();

	public Book getBook(Long id);

	public List<Book> getBooksByUserId(Long userId);
	
	public List<Book> getBooksByStatus(Long userId, String status);
}
