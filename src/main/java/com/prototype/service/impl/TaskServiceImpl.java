package com.prototype.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.domain.StateTask;
import com.prototype.domain.Task;
import com.prototype.domain.TaskUser;
import com.prototype.domain.User;
import com.prototype.dto.StateTaskDto;
import com.prototype.dto.TaskDto;
import com.prototype.dto.UserDto;
import com.prototype.mapper.ActivityMapper;
import com.prototype.mapper.TaskMapper;
import com.prototype.mapper.UserMapper;
import com.prototype.repository.TaskRepository;
import com.prototype.repository.TaskStateRepository;
import com.prototype.repository.TaskUserRepository;
import com.prototype.repository.UserRepository;
import com.prototype.service.TaskService;
@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	private UserRepository userRepository;
	private TaskRepository taskRepository;
	private TaskUserRepository taskUserRepository;
	private TaskStateRepository taskStateRepository;
	
	@Autowired
	public TaskServiceImpl(UserRepository userRepository, TaskRepository taskRepository,
			TaskUserRepository taskUserRepository, TaskStateRepository taskStateRepository) {
		this.userRepository = userRepository;
		this.taskRepository = taskRepository;
		this.taskUserRepository = taskUserRepository;
		this.taskStateRepository = taskStateRepository;
	}


	@Override
	public TaskDto create(TaskDto taskRequestDto, String userTokenHeader) {
		Task task = new Task();
		task.setCreatedBy(userRepository.findByUsername(userTokenHeader));
		task.setCreatedDate(taskRequestDto.getCreatedDate());
		task.setDescription(taskRequestDto.getDescription());
		task.setEndDuration(taskRequestDto.getEndDuration());
		task.setStartDuration(taskRequestDto.getStartDuration());
		task.setStateTask(new StateTask(taskRequestDto.getStateTask().getIdStateTask()));
		task.setTittle(taskRequestDto.getTittle());
		Task taskSaved = taskRepository.save(task);
		System.out.println("saved Task # " + taskSaved.getIdTask());
		Optional.ofNullable(taskRequestDto.getUsersAsignedToTask())
				.ifPresent(users -> users.forEach((user) -> taskUserRepository
						.save(new TaskUser(new Task(taskSaved.getIdTask()), new User(user.getIdUser())))));
		return TaskMapper.mapperTaskToTaskDto(taskSaved);
	}
	
	

	@Override
	public TaskDto update(TaskDto taskRequestDto, String userTokenHeader) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDto> getAllTaskDetails() {
		List<TaskDto> taskResponse = new ArrayList<>();
		List<Task> tasks = taskRepository.findAll();
		for (Task task : tasks) {
			TaskDto taskDto = TaskMapper.mapperTaskToTaskDto(task);
			List<UserDto> usersAsignedToTask= findActivityUserByTask(task.getIdTask());
			taskDto.setUsersAsignedToTask(usersAsignedToTask);
			taskResponse.add(taskDto);
		}
		return taskResponse;
	}

	@Override
	public List<StateTaskDto> getStatesTask() {
		return taskStateRepository.findAll().stream()
				.map(TaskMapper::mapperTaskStateToTaskStateDto)
				.collect(Collectors.toList());
	}
	
	// AUXILIAR METHOD
			public List<UserDto> findActivityUserByTask(Long idTask) {
				List<UserDto> usersAsignedToTask = new ArrayList<>();
				taskUserRepository.findTaskUserByTask(new Task(idTask)).forEach((tk) -> {
					User userAsigned = userRepository.findByUsername(tk.getUser().getUsername());
					usersAsignedToTask.add(UserMapper.mapperUserToUserDto(userAsigned));
				});
				return usersAsignedToTask;
			}

}
