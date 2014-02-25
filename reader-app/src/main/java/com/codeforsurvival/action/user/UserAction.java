package com.codeforsurvival.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.codeforsurvival.db.entity.User;
import com.codeforsurvival.manager.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UserAction extends ActionSupport implements ModelDriven<User>,
		Preparable {

	@Autowired
	private UserManager userManager;
	private User user = new User();
	String action = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1069271513915160515L;

	public String execute() {
		if (action != null && action.equals("edit"))
			return "edit";
		else if (action != null && action.equals("profile"))
			return "profile";
		else
			return "view";
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

	public void prepare() throws Exception {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = auth.getName();
		this.setUser(userManager.getUserByUsername(username));
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
