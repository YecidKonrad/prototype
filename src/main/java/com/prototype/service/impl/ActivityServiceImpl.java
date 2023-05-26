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
import com.prototype.domain.ActivityPhase;
import com.prototype.domain.ActivityUser;
import com.prototype.domain.Phase;
import com.prototype.domain.StateActivity;
import com.prototype.domain.StatePhase;
import com.prototype.domain.Task;
import com.prototype.domain.TaskActivity;
import com.prototype.domain.User;
import com.prototype.domain.UserActivityKey;
import com.prototype.dto.ActivityDto;
import com.prototype.dto.ActivityRequestDto;
import com.prototype.dto.StateActivityDto;
import com.prototype.dto.StatePhaseDto;
import com.prototype.dto.TaskDto;
import com.prototype.dto.UserDto;
import com.prototype.mapper.ActivityMapper;
import com.prototype.mapper.TaskMapper;
import com.prototype.mapper.UserMapper;
import com.prototype.repository.ActivityPhaseRepository;
import com.prototype.repository.ActivityRepository;
import com.prototype.repository.ActivityStateRepository;
import com.prototype.repository.ActivityUserRepository;
import com.prototype.repository.PhaseRepository;
import com.prototype.repository.TaskActivityRepository;
import com.prototype.repository.TaskRepository;
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
	private TaskActivityRepository taskActivityRepository;
	private TaskRepository taskRepository;
	private ActivityPhaseRepository activityPhaseRepository;
	private PhaseRepository phaseRepository;
	
	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository, UserRepository userRepository,
			ActivityUserRepository activityUserRepository, ActivityStateRepository activityStateRepository,
			TaskActivityRepository taskActivityRepository,  TaskRepository taskRepository,
			ActivityPhaseRepository activityPhaseRepository, PhaseRepository phaseRepository) {
		this.activityRepository = activityRepository;
		this.userRepository = userRepository;
		this.activityUserRepository = activityUserRepository;
		this.activityStateRepository = activityStateRepository;
		this.taskActivityRepository = taskActivityRepository;
		this.taskRepository = taskRepository;
		this.activityPhaseRepository = activityPhaseRepository;
		this.phaseRepository = phaseRepository;
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
		
		Optional.ofNullable(activityRequestDto.getTasksAsignedToActivity()).ifPresent(tasks -> tasks.forEach((task) -> {
			taskActivityRepository.save(new TaskActivity(new Activity(activitySaved.getIdActivity()), new Task(task.getIdTask())));
		}));
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
			activityResponseDto.setTasksAsignedToActivity(findTaskActivityByActivity(activity.getIdActivity()));
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

		public List<TaskDto> findTaskActivityByActivity(Long idActivity) {
			List<TaskDto> tasksAsignedToActivity = new ArrayList<>();
			taskActivityRepository.findTaskActivityByActivity(new Activity(idActivity)).forEach((ta) -> {
				Task taskAsigned = taskRepository.findById(ta.getTask().getIdTask()).get();
				tasksAsignedToActivity.add(TaskMapper.mapperTaskToTaskDto(taskAsigned));
			});
			return tasksAsignedToActivity;
		}

		@Override
		public List<StateActivityDto> getStateActivities() {
			return activityStateRepository.findAll().stream()
					.map(ActivityMapper::mapperActivityStateToActivityStateDto)
					.collect(Collectors.toList());
		}


		@Override
		public ActivityDto update(ActivityRequestDto activityRequestDto, String userTokenHeder) {
			validateLastActivityFinishOfPhase(activityRequestDto.getIdActivity(), activityRequestDto.getStateActivity());
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
			Optional.ofNullable(activityRequestDto.getUsersAsignedToActivity()).ifPresent(users -> users.forEach((user) ->{
			Optional<ActivityUser>  activityUser = activityUserRepository.findById(new UserActivityKey(activityUpdated.getIdActivity(), user.getIdUser()));
				if (!activityUser.isPresent()) {
					activityUserRepository.save(new ActivityUser(new Activity(activityUpdated.getIdActivity()),	new User(user.getIdUser())));
				}
				}));
			return ActivityMapper.mapperActivityToActivityDto(activityUpdated);
		}
		
		public void validateLastActivityFinishOfPhase(Long idActivity, StateActivityDto stateActivityDto) {
		    List<ActivityPhase> activitiesPhase = activityPhaseRepository.findActivityPhaseByActivity(new Activity(idActivity));
		    if (activitiesPhase.isEmpty()) {
		        return;
		    }
		    
		    Long phaseId = activitiesPhase.get(0).getIdActivityPhaseKey().getIdPhase();
		    List<ActivityPhase> activitiesPhasesNoFinished = activityPhaseRepository.findActivityPhaseByPhase(new Phase(phaseId))
		            .stream()
		            .filter(taskActivity -> !taskActivity.getPhase().getStatePhase().getState().equalsIgnoreCase("Finalizada"))
		            .collect(Collectors.toList());
		    
		    if (activitiesPhasesNoFinished.size() == 1 && stateActivityDto.getState().equalsIgnoreCase("Finalizada")) {
		        Phase phaseChangeState = phaseRepository.findById(activitiesPhasesNoFinished.get(0).getPhase().getIdPhase()).orElse(null);
		        if (phaseChangeState != null) {
		        	phaseChangeState.setStatePhase(new StatePhase(3L));
		            phaseRepository.save(phaseChangeState);
		        }
		    }
		}


}
