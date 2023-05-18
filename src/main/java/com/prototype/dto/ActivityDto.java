package com.prototype.dto;

import java.util.Date;
import java.util.List;

public class ActivityDto {
	private Long idActivity;
	private String tittle;
	private String description;
	private Date startDuration;
	private Date endDuration;
	private Date createdDate;
	private int priority;
	private StateActivityDto stateActivityDto;
	private UserDto createdBy;
	private List<UserDto> UsersasignedToActivity;
	
	public ActivityDto(Long idActivity, String tittle, String description, Date startDuration, Date endDuration,
			Date createdDate, int priority, StateActivityDto stateActivityDto, UserDto createdBy,
			List<UserDto> usersasignedToActivity) {
		this.idActivity = idActivity;
		this.tittle = tittle;
		this.description = description;
		this.startDuration = startDuration;
		this.endDuration = endDuration;
		this.createdDate = createdDate;
		this.priority = priority;
		this.stateActivityDto = stateActivityDto;
		this.createdBy = createdBy;
		UsersasignedToActivity = usersasignedToActivity;
	}

	public ActivityDto() {
	}

	public Long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public StateActivityDto getStateActivityDto() {
		return stateActivityDto;
	}

	public void setStateActivityDto(StateActivityDto stateActivityDto) {
		this.stateActivityDto = stateActivityDto;
	}

	public UserDto getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDto createdBy) {
		this.createdBy = createdBy;
	}

	public List<UserDto> getUsersasignedToActivity() {
		return UsersasignedToActivity;
	}

	public void setUsersasignedToActivity(List<UserDto> usersasignedToActivity) {
		UsersasignedToActivity = usersasignedToActivity;
	}
	
	

	

}
