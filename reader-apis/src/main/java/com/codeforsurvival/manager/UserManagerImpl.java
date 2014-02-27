package com.codeforsurvival.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codeforsurvival.db.entity.User;
import com.codeforsurvival.service.UserService;

@Component
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserService userService;

	public List<User> getAllUser() {
		return userService.getAllUsers();
	}

	public User addUser(User user) {
		return this.userService.addUser(user);
	}

	public User getUserByUsername(String username) {
		return this.userService.getUserByUsername(username);
	}

	public User getUser(Long id) {
		return this.userService.getUserById(id);
	}

	public User deleteUserById(Long id) {
		return this.userService.deleteUserById(id);
	}

	public User deleteUser(User user) {
		return this.userService.deleteUser(user);
	}

}
