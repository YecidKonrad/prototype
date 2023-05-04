package com.prototype.mapper;

import com.prototype.domain.Activity;
import com.prototype.domain.StateActivity;
import com.prototype.dto.ActivityDto;

public class ActivityMapper {
	public static ActivityDto mapperActivityToActivityDto(Activity activity) {
		ActivityDto activityDto = new ActivityDto();
		activityDto.setCreatedBy(UserMapper.mapperUserToUserDto(activity.getCreatedBy()));
		activityDto.setCreatedDate(activity.getCreatedDate());
		activityDto.setDescription(activity.getDescription());
		activityDto.setEndDuration(activity.getEndDuration());
		activityDto.setIdActivity(activity.getIdActivity());
		activityDto.setPriority(activity.getPriority());
		activityDto.setStartDuration(activity.getStartDuration());
		activityDto.setStateActivity(new StateActivity(activity.getStateActivity().getIdStateActivity(), activity.getStateActivity().getState()));
		activityDto.setTittle(activity.getTittle());
		return activityDto;
	}

}
