package com.codeforsurvival.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
		return userManager.addUser(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	User getUserById(@PathVariable Long id) {
		return userManager.getUser(id);
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

}