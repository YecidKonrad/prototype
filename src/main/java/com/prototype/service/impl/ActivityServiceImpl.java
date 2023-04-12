package com.prototype.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.domain.Activity;
import com.prototype.domain.ActivityUser;
import com.prototype.domain.StateActivity;
import com.prototype.domain.User;
import com.prototype.dto.ActivityRequestDto;
import com.prototype.dto.ActivityResponseDto;
import com.prototype.repository.ActivityRepository;
import com.prototype.repository.ActivityUserRepository;
import com.prototype.repository.UserRepository;
import com.prototype.service.ActivityService;

@Service
@Transactional
//@Qualifier("activityDetailsService")
public class ActivityServiceImpl implements ActivityService {
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private ActivityRepository activityRepository;
	private UserRepository userRepository;
	private ActivityUserRepository activityUserRepository;
	
	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository, UserRepository userRepository,
			ActivityUserRepository activityUserRepository) {
		this.activityRepository = activityRepository;
		this.userRepository = userRepository;
		this.activityUserRepository = activityUserRepository;
	}


	@Override
	public ActivityResponseDto create(ActivityRequestDto activityRequestDto, String userTokenHeder) {
		Activity activity = new Activity();
		activity.setCreatedBy(userRepository.findByUsername(userTokenHeder));
		activity.setCreatedDate(activityRequestDto.getCreatedDate());
		activity.setDescription(activityRequestDto.getDescription());
		activity.setEndDuration(activityRequestDto.getEndDuration());
		activity.setPriority(activityRequestDto.getPriority());
		activity.setStartDuration(activityRequestDto.getStartDuration());
		activity.setStateActivity(new StateActivity(activityRequestDto.getIdStateActivity()));
		activity.setTittle(activityRequestDto.getTittle());
		Activity activitySaved = activityRepository.save(activity);
		activityRequestDto.getUsersAsingActivity().forEach((key, value) -> userRepository.findByUsername(value));
		activityRequestDto.getUsersAsingActivity().forEach((key, value) -> activityUserRepository
				.save(new ActivityUser(new Activity(activitySaved.getIdActivity()), new User(key))));
		return new ActivityResponseDto(activitySaved.getIdActivity(), activitySaved.getTittle());
	}

}
