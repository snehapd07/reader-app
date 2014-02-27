package com.codeforsurvival.api;

import java.util.Arrays;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.codeforsurvival.common.enums.ActivityStatus;
import com.codeforsurvival.db.entity.Activity;
import com.codeforsurvival.manager.ActivityManager;

@Controller
@RequestMapping(value = "/activiti", produces = MediaType.APPLICATION_JSON_VALUE)
public class ActivityController {

	@Autowired
	private ActivityManager activityManager;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public @ResponseBody
	Activity addActivity(@RequestBody Activity activity) {
		return activityManager.addActivity(activity);
	}

	@RequestMapping(value = { "/{userId}" }, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, List<Activity>> getActivityByUserId(@PathVariable Long userId) {
		Map<String, List<Activity>> result = new HashMap<String, List<Activity>>();
		result.put("activiti", activityManager.getActivityByUserId(userId));
		return result;
	}

	@RequestMapping(value = { "/{bookId}" }, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, List<Activity>> getActivityByBookId(@PathVariable Long bookId) {
		Map<String, List<Activity>> result = new HashMap<String, List<Activity>>();
		result.put("activiti", activityManager.getActivityByUserId(bookId));
		return result;
	}

	@RequestMapping(value = { "/{userId}/{bookId}" }, method = RequestMethod.GET)
	public @ResponseBody
	Activity getActivityByUserId(@PathVariable Long userId,
			@PathVariable Long bookId) {
		return activityManager.getActivity(userId, bookId);
	}

	@RequestMapping(value = { "/statusoptions" }, method = RequestMethod.GET)
	public @ResponseBody
	List<ActivityStatus> getActivityStatusOptions() {
		return Arrays.asList(ActivityStatus.values());
	}
}
