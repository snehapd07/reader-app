package com.codeforsurvival.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.codeforsurvival.db.entity.User;
import com.codeforsurvival.manager.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class WelcomeAction extends ActionSupport implements ModelDriven<User>,
		Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6286443540568846876L;
	@Autowired
	private UserManager userManager;
	private String error;
	private String response;
	private User user = new User();

	public String execute() {

		return SUCCESS;
	}

	public void prepare() throws Exception {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = auth.getName();
		this.setUser(userManager.getUserByUsername(username));
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
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

}
