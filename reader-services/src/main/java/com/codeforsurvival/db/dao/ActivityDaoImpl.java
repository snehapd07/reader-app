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

public class ActivityDaoImpl implements ActivityDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Activity addActivity(Activity activity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if (null != (Long) activity.getId()) {
				session.saveOrUpdate(activity);
			} else {
				Long id = (Long) session.save(activity);
				activity.setId(id);
			}
			tx.commit();
			tx = session.beginTransaction();
			Double res = this.getOverAllBookRating(activity.getBookId());
			Criteria cr = session.createCriteria(Book.class);
			cr.add(Restrictions.eq("id", activity.getBookId()));
			if (cr.list() != null && !cr.list().isEmpty()) {
				Book book = (Book) cr.list().get(0);
				book.setRating(res);
				session.saveOrUpdate(book);
			}
			tx.commit();
			return activity;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return activity;
	}

	public Activity getActivity(Long userId, Long bookId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Activity.class);
			cr.add(Restrictions.eq("userId", userId));
			cr.add(Restrictions.eq("bookId", bookId));
			@SuppressWarnings("unchecked")
			List<Activity> list = cr.list();
			Activity activity = new Activity();
			if (null != list && !list.isEmpty()) {
				activity = (Activity) list.get(0);

			}
			tx.commit();
			return activity;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Activity> getActivityByUserId(Long userId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Activity.class);
			cr.add(Restrictions.eq("userId", userId));
			@SuppressWarnings("unchecked")
			List<Activity> list = cr.list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Activity> getActivityByBookId(Long bookId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Activity.class);
			cr.add(Restrictions.eq("userId", bookId));
			@SuppressWarnings("unchecked")
			List<Activity> list = cr.list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Double getOverAllBookRating(Long bookId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Activity.class);
			cr.setProjection(Projections.avg("ratedByUser"));
			cr.add(Restrictions.eq("bookId", bookId));
			cr.add(Restrictions.ne("ratedByUser", new Double(0)));
			cr.add(Restrictions.isNotNull(("ratedByUser")));
			Double res = (Double) cr.list().get(0);
			tx.commit();
			return res;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
