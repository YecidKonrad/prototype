package com.prototype.service;

import java.util.List;

import com.prototype.domain.Activity;
import com.prototype.dto.ActivityDto;
import com.prototype.dto.ActivityRequestDto;
import com.prototype.dto.StateActivityDto;

public interface ActivityService {

	public ActivityDto create(ActivityRequestDto activityRequestDto, String userTokenHeder);
	public List<Activity> getActivities();
	public List<ActivityDto> getAllActivitiesDetails();
	public List<StateActivityDto> getStateActivities();
	public ActivityDto update(ActivityRequestDto activityRequestDto, String userTokenHeder);

}
