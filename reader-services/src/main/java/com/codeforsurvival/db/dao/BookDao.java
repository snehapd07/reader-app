package com.codeforsurvival.db.dao;

import java.util.List;

import com.codeforsurvival.db.entity.Book;

interface BookDao {

	public Book addBook(Book book);

	public List<Book> getAllBooks();

	public Book getBook(Long id);

}
