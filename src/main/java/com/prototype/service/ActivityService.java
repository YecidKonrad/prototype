package com.prototype.service;

import java.util.List;

import com.prototype.domain.Activity;
import com.prototype.dto.ActivityDto;
import com.prototype.dto.ActivityRequestDto;

public interface ActivityService {

	ActivityDto create(ActivityRequestDto activityRequestDto, String userTokenHeder);

	List<Activity> getActivities();
   
}
