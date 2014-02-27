package com.codeforsurvival.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codeforsurvival.db.entity.User;
import com.codeforsurvival.manager.UserManager;

@Controller
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	@Autowired
	private UserManager userManager;

	@RequestMapping(value = { "/", "", "/all " }, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, List<User>> getAllUsers() {
		Map<String, List<User>> result = new HashMap<String, List<User>>();
		result.put("users", userManager.getAllUser());
		return result;

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	User addUser(@RequestBody User user) {
		if (null == user.getId())
			throw new IllegalAccessError();
		return userManager.addUser(user);
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public @ResponseBody
	User getUserById() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = auth.getName();
		return userManager.getUserByUsername(username);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	User deleteUserById(@PathVariable Long id) {
		return userManager.deleteUserById(id);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	User deleteUser(@RequestBody User user) {
		return userManager.deleteUser(user);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/j_spring_security_logout";
	}

}