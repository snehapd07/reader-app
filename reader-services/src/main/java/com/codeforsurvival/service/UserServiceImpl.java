package com.codeforsurvival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeforsurvival.db.dao.UserDao;
import com.codeforsurvival.db.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User addUser(User user) {
		return this.userDao.addUser(user);
	}

	public String getUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
