package com.codeforsurvival.db.dao;

import java.util.List;

import com.codeforsurvival.db.entity.Activity;

public interface ActivityDao {

	public Activity addActivity(Activity activity);

	public Activity getActivity(Long userId, Long bookId);

	public List<Activity> getActivityByUserId(Long userId);
	
	public List<Activity> getActivityByBookId(Long bookId);

}
