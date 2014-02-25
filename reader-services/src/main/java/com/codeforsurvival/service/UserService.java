package com.codeforsurvival.service;

import java.util.List;

import com.codeforsurvival.db.entity.User;

public interface UserService {

	public User addUser(User user);

	public User getUserById(long id);

	public User getUserByUsername(String username);

	public List<User> getAllUsers();

	public User deleteUserById(Long id);

	public User deleteUser(User user);
}
