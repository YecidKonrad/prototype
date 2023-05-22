package com.prototype.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TaskDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idTask;
	private String tittle;
	private String description;
	private Date startDuration;
	private Date endDuration;
	private Date createdDate;
	private List<UserDto> usersAsignedToTask;
	private UserDto createdBy;
	private StateTaskDto stateTask;
	
	public TaskDto() {
	}

	public TaskDto(Long idTask, String tittle, String description, Date startDuration, Date endDuration,
			Date createdDate, List<UserDto> usersAsignedToTask, UserDto createdBy, StateTaskDto stateTask) {
		this.idTask = idTask;
		this.tittle = tittle;
		this.description = description;
		this.startDuration = startDuration;
		this.endDuration = endDuration;
		this.createdDate = createdDate;
		this.usersAsignedToTask = usersAsignedToTask;
		this.createdBy = createdBy;
		this.stateTask = stateTask;
	}

	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDuration() {
		return startDuration;
	}

	public void setStartDuration(Date startDuration) {
		this.startDuration = startDuration;
	}

	public Date getEndDuration() {
		return endDuration;
	}

	public void setEndDuration(Date endDuration) {
		this.endDuration = endDuration;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<UserDto> getUsersAsignedToTask() {
		return usersAsignedToTask;
	}

	public void setUsersAsignedToTask(List<UserDto> usersAsignedToTask) {
		this.usersAsignedToTask = usersAsignedToTask;
	}

	public UserDto getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDto createdBy) {
		this.createdBy = createdBy;
	}

	public StateTaskDto getStateTask() {
		return stateTask;
	}

	public void setStateTask(StateTaskDto stateTask) {
		this.stateTask = stateTask;
	}


}
