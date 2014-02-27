package com.codeforsurvival.db.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeforsurvival.db.entity.UserRoles;

public class UserRolesDaoImpl implements UserRolesDao {
	@Autowired
	SessionFactory sessionFactory;

	public UserRoles addUserRoles(UserRoles userRoles) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if (null != (Long) userRoles.getUserRoleId()) {
				session.saveOrUpdate(userRoles);
			} else {
				Long userRoleId = (Long) session.save(userRoles);
				userRoles.setUserRoleId(userRoleId);
			}
			tx.commit();
			return userRoles;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
