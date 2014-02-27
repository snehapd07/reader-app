package com.codeforsurvival.service;

import java.util.List;

import com.codeforsurvival.db.entity.Activity;

public interface ActivityService {
	public Activity addActivity(Activity activity);

	public Activity getActivity(Long userId, Long bookId);
	
	public List<Activity> getActivityByUserId(Long userId);
	
	public List<Activity> getActivityByBookId(Long bookId);
}
