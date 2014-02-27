package com.codeforsurvival.manager;

import org.springframework.beans.factory.annotation.Autowired;

import com.codeforsurvival.db.entity.UserRoles;
import com.codeforsurvival.service.UserRolesService;

public class UserRolesManagerImpl implements UserRolesManager {

	@Autowired
	UserRolesService userRolesService;

	public UserRoles addUserRoles(UserRoles userRoles) {
		return userRolesService.addUserRoles(userRoles);
	}

}
