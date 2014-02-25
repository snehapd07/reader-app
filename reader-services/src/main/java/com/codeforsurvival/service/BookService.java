package com.codeforsurvival.service;

import java.util.List;

import com.codeforsurvival.db.entity.Book;

public interface BookService {

	public Book addBook(Book book);

	public List<Book> getAllBooks();

	public Book getBook(Long id);
}
