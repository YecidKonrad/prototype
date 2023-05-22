package com.prototype.service;

import java.util.List;

import com.prototype.dto.StateTaskDto;
import com.prototype.dto.TaskDto;

public interface TaskService {

	public TaskDto create(TaskDto taskRequestDto, String userTokenHeader);

	public TaskDto update(TaskDto taskRequestDto, String userTokenHeader);

	public List<TaskDto> getAllTaskDetails();

	public List<StateTaskDto> getStatesTask();

}
