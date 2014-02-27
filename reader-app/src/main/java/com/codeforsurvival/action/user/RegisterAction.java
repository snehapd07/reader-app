package com.codeforsurvival.action.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.codeforsurvival.db.entity.User;
import com.codeforsurvival.db.entity.UserRoles;
import com.codeforsurvival.manager.UserManager;
import com.codeforsurvival.manager.UserRolesManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	@Autowired
	private UserManager userManager;
	@Autowired
	private UserRolesManager userRolesManager;
	private User user = new User();
	String action = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1069271513915160515L;

	public String execute() {
		if (action != null && action.equals("save")) {
			user.setEnabled(true);
			user.setUserType("reader");
			user = this.userManager.addUser(user);
			if (user != null) {
				UserRoles userRoles = new UserRoles(null, user.getId(),
						"ROLE_USER");
				this.userRolesManager.addUserRoles(userRoles);
				return "login";
			} else
				return SUCCESS;
		} else
			return SUCCESS;
	}

	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
