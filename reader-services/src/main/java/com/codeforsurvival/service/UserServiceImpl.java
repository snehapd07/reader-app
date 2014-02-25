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

	public User getUserById(long id) {
		return this.userDao.getUserById(id);
	}

	public User getUserByUsername(String username) {
		return this.userDao.getUserByUsername(username);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User deleteUserById(Long id) {
		return this.userDao.deleteUserById(id);
	}

	public User deleteUser(User user) {
		return this.userDao.deleteUser(user);
	}

}
