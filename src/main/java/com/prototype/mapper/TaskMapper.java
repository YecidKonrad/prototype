package com.prototype.mapper;

import com.prototype.domain.StateTask;
import com.prototype.domain.Task;
import com.prototype.dto.StateActivityDto;
import com.prototype.dto.StateTaskDto;
import com.prototype.dto.TaskDto;

public class TaskMapper {
	
	public static TaskDto mapperTaskToTaskDto(Task task) {
		TaskDto taskDto = new TaskDto();
		taskDto.setIdTask(task.getIdTask());
		taskDto.setCreatedBy(UserMapper.mapperUserToUserDto(task.getCreatedBy()));
		taskDto.setCreatedDate(task.getCreatedDate());
		taskDto.setDescription(task.getDescription());
		taskDto.setEndDuration(task.getEndDuration());
		taskDto.setStartDuration(task.getStartDuration());
		taskDto.setStateTask(new StateTaskDto(task.getStateTask().getIdStateTask(),task.getStateTask().getState()));
		taskDto.setTittle(task.getTittle());
		return taskDto;
		
	}
	
	public static StateTaskDto mapperTaskStateToTaskStateDto(StateTask stateTask) {
		StateTaskDto stateTaskDto = new StateTaskDto();
		stateTaskDto.setIdStateTask(stateTask.getIdStateTask());
		stateTaskDto.setState(stateTask.getState());
		return stateTaskDto;
	}
	

}
