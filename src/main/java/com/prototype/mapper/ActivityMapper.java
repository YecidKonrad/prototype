package com.prototype.mapper;

import com.prototype.domain.Activity;
import com.prototype.domain.StateActivity;
import com.prototype.domain.StatePhase;
import com.prototype.dto.ActivityDto;
import com.prototype.dto.StateActivityDto;
import com.prototype.dto.StatePhaseDto;

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
		activityDto.setStateActivity(new StateActivityDto(activity.getStateActivity().getIdStateActivity(), activity.getStateActivity().getState()));
		activityDto.setTittle(activity.getTittle());
		return activityDto;
	}
	
	
	public static StateActivityDto mapperActivityStateToActivityStateDto(StateActivity stateActivity) {
		StateActivityDto stateActivityDto = new StateActivityDto();
		stateActivityDto.setIdStateActivity(stateActivity.getIdStateActivity());
		stateActivityDto.setState(stateActivity.getState());
		return stateActivityDto;
	}

}
