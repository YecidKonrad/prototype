package com.prototype.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.domain.Activity;
import com.prototype.domain.ActivityUser;
import com.prototype.domain.StateActivity;
import com.prototype.domain.User;
import com.prototype.dto.ActivityDto;
import com.prototype.dto.ActivityRequestDto;
import com.prototype.dto.StateActivityDto;
import com.prototype.dto.UserDto;
import com.prototype.mapper.ActivityMapper;
import com.prototype.mapper.UserMapper;
import com.prototype.repository.ActivityRepository;
import com.prototype.repository.ActivityStateRepository;
import com.prototype.repository.ActivityUserRepository;
import com.prototype.repository.UserRepository;
import com.prototype.service.ActivityService;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private ActivityRepository activityRepository;
	private UserRepository userRepository;
	private ActivityUserRepository activityUserRepository;
	private ActivityStateRepository activityStateRepository;
	
	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository, UserRepository userRepository,
			ActivityUserRepository activityUserRepository, ActivityStateRepository activityStateRepository) {
		this.activityRepository = activityRepository;
		this.userRepository = userRepository;
		this.activityUserRepository = activityUserRepository;
		this.activityStateRepository = activityStateRepository;
	}


	@Override
	public ActivityDto create(ActivityRequestDto activityRequestDto, String userTokenHeder) {
		Activity activity = new Activity();
		activity.setCreatedBy(userRepository.findByUsername(userTokenHeder));
		activity.setCreatedDate(new Date());
		activity.setDescription(activityRequestDto.getDescription());
		activity.setEndDuration(activityRequestDto.getEndDuration());
		activity.setPriority(activityRequestDto.getPriority());
		activity.setStartDuration(activityRequestDto.getStartDuration());
		activity.setStateActivity(new StateActivity(activityRequestDto.getStateActivity().getIdStateActivity()));
		activity.setTittle(activityRequestDto.getTittle());
		Activity activitySaved = activityRepository.save(activity);
		System.out.println("saved Activity # " + activitySaved.getIdActivity());
		Optional.ofNullable(activityRequestDto.getUsersAsignedToActivity()).ifPresent(users -> users.forEach((user) ->
			activityUserRepository.save(new ActivityUser(new Activity(activitySaved.getIdActivity()), new User(user.getIdUser())))));
		return ActivityMapper.mapperActivityToActivityDto(activitySaved);
	}


	@Override
	public List<Activity> getActivities() {
		return activityRepository.findAll();
	}
	
	public List<ActivityDto> getAllActivitiesDetails() {
		List<ActivityDto> activitiesResponse = new ArrayList<>();
		List<Activity> activivities = activityRepository.findAll();
		for (Activity activity : activivities) {
			ActivityDto activityResponseDto = ActivityMapper.mapperActivityToActivityDto(activity);
			List<UserDto> usersAsignedToActivity = findActivityUserByActivity(activity.getIdActivity());
			activityResponseDto.setUsersAsignedToActivity(usersAsignedToActivity);
			activitiesResponse.add(activityResponseDto);
		}
		return activitiesResponse;
	}
	
	// AUXILIAR METHOD
		public List<UserDto> findActivityUserByActivity(Long idActivity) {
			List<UserDto> usersAsignedToActivity = new ArrayList<>();
			activityUserRepository.findActivityUserByActivity(new Activity(idActivity)).forEach((ac) -> {
				User userAsigned = userRepository.findByUsername(ac.getUser().getUsername());
				usersAsignedToActivity.add(UserMapper.mapperUserToUserDto(userAsigned));
			});
			return usersAsignedToActivity;
		}


		@Override
		public List<StateActivityDto> getStateActivities() {
			return activityStateRepository.findAll().stream()
					.map(ActivityMapper::mapperActivityStateToActivityStateDto)
					.collect(Collectors.toList());
		}


		@Override
		public ActivityDto update(ActivityRequestDto activityRequestDto, String userTokenHeder) {
			Activity activity = new Activity();
			activity.setIdActivity(activityRequestDto.getIdActivity());
			activity.setCreatedBy(userRepository.findByUsername(userTokenHeder));
			activity.setCreatedDate(new Date());
			activity.setDescription(activityRequestDto.getDescription());
			activity.setEndDuration(activityRequestDto.getEndDuration());
			activity.setPriority(activityRequestDto.getPriority());
			activity.setStartDuration(activityRequestDto.getStartDuration());
			activity.setStateActivity(new StateActivity(activityRequestDto.getStateActivity().getIdStateActivity()));
			activity.setTittle(activityRequestDto.getTittle());
			Activity activityUpdated = activityRepository.save(activity);
			System.out.println("update Activity # " + activityUpdated.getIdActivity());
			/*Optional.ofNullable(activityRequestDto.getUsersAsignedToActivity()).ifPresent(users -> users.forEach((user) ->{
			Optional<ActivityUser>  activityUser = activityUserRepository.findById(new UserActivityKey(activityUpdated.getIdActivity(), user.getIdUser()));
				if (!activityUser.isPresent()) {
					activityUserRepository.save(new ActivityUser(new Activity(activityUpdated.getIdActivity()),	new User(user.getIdUser())));
				}
				}));*/
			return ActivityMapper.mapperActivityToActivityDto(activityUpdated);
		}

}
