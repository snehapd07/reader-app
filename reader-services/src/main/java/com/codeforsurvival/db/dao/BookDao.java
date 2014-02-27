package com.codeforsurvival.db.dao;

import java.util.List;

import com.codeforsurvival.db.entity.Book;

public interface BookDao {

	public Book addBook(Book book);

	public List<Book> getAllBooks();

	public Book getBook(Long id);

	public List<Book> getBooksByUserId(Long userId);

}
