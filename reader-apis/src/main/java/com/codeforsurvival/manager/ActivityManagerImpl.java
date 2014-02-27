package com.codeforsurvival.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codeforsurvival.db.entity.Activity;
import com.codeforsurvival.service.ActivityService;

public class ActivityManagerImpl implements ActivityManager {

	@Autowired
	ActivityService activityService;

	public Activity addActivity(Activity activity) {
		return activityService.addActivity(activity);
	}

	public Activity getActivity(Long userId, Long bookId) {
		return activityService.getActivity(userId, bookId);
	}

	public List<Activity> getActivityByUserId(Long userId) {
		return activityService.getActivityByUserId(userId);
	}

	public List<Activity> getActivityByBookId(Long bookId) {
		return activityService.getActivityByBookId(bookId);
	}

}
