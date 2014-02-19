package com.codeforsurvival.service;

import java.util.List;

import com.codeforsurvival.db.entity.User;

public interface UserService {

	public User addUser(User user);

	public String getUser(long id);

	public List<User> getAllUsers();
}
