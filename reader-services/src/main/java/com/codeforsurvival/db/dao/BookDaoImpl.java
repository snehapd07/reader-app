package com.codeforsurvival.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeforsurvival.db.entity.Book;
import com.codeforsurvival.db.entity.User;

public class BookDaoImpl implements BookDao {
	@Autowired
	SessionFactory sessionFactory;

	public Book addBook(Book book) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if (book.getId() != 0) {
				session.saveOrUpdate(book);
			} else {
				Long id = (Long) session.save(book);
				book.setId(id);
			}
			tx.commit();
			return book;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Book> getAllBooks() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Book.class);
			@SuppressWarnings("unchecked")
			List<Book> list = cr.list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Book getBook(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("id", id));
			Book book = (Book) cr.list().get(0);
			tx.commit();
			return book;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
