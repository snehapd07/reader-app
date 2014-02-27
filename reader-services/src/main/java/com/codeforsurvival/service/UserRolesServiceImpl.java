package com.codeforsurvival.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.codeforsurvival.db.dao.UserRolesDao;
import com.codeforsurvival.db.entity.UserRoles;

public class UserRolesServiceImpl implements UserRolesService {
	@Autowired
	UserRolesDao userRolesDao;

	public UserRoles addUserRoles(UserRoles userRoles) {
		return userRolesDao.addUserRoles(userRoles);
	}
}
