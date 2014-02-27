package com.codeforsurvival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codeforsurvival.db.dao.ActivityDao;
import com.codeforsurvival.db.entity.Activity;

public class ActivityServiceImpl implements ActivityService {

	@Autowired
	ActivityDao activityDao;

	public Activity addActivity(Activity activity) {
		return activityDao.addActivity(activity);
	}

	public Activity getActivity(Long userId, Long bookId) {
		return activityDao.getActivity(userId, bookId);
	}

	public List<Activity> getActivityByUserId(Long userId) {
		return activityDao.getActivityByUserId(userId);
	}

	public List<Activity> getActivityByBookId(Long bookId) {
		return activityDao.getActivityByBookId(bookId);
	}
}
