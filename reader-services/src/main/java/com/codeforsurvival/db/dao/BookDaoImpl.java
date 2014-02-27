package com.codeforsurvival.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeforsurvival.db.entity.Activity;
import com.codeforsurvival.db.entity.Book;
import com.codeforsurvival.db.entity.User;

class BookDaoImpl implements BookDao {
	@Autowired
	SessionFactory sessionFactory;

	public Book addBook(Book book) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if (null != (Long) book.getId()) {
				session.update(book);
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
			Criteria cr = session.createCriteria(Book.class);
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

	public List<Book> getBooksByUserId(Long userId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Book.class);
			cr.add(Restrictions.eq("addedBy", userId));
			@SuppressWarnings("unchecked")
			List<Book> list = (List<Book>) cr.list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Book> getBooksByStatus(Long userId, String status) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		if (null != status && !status.isEmpty() && !status.equals("null")) {
			try {
				tx = session.beginTransaction();
				Criteria cr = session.createCriteria(Activity.class);
				cr.add(Restrictions.eq("userId", userId));
				cr.add(Restrictions.eq("status", status));
				cr.setProjection(Projections.property("bookId"));
				@SuppressWarnings("unchecked")
				List<String> list = (List<String>) cr.list();
				cr = session.createCriteria(Book.class);
				if (list != null && !list.isEmpty()) {
					cr.add(Restrictions.in("id", list));
					return cr.list();
				}
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			return this.getAllBooks();
		}
		return null;
	}
}
