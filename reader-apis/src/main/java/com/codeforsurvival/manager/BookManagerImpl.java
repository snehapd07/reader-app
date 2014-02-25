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
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	public Book getBook(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
