package com.prototype.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.prototype.domain.User;

public class ActivityRequestDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idActivity;
	private String tittle;
	private String description;
	private Date startDuration;
	private Date endDuration;
	private Date createdDate;
	private int priority;
	private List<UserDto> usersAsignedToActivity;
	private User createdBy;
	private StateActivityDto stateActivity;
	
	
	public ActivityRequestDto(Long idActivity, String tittle, String description, Date startDuration, Date endDuration,
			Date createdDate, int priority, List<UserDto> usersAsignedToActivity, User createdBy,
			StateActivityDto stateActivity) {
		this.idActivity = idActivity;
		this.tittle = tittle;
		this.description = description;
		this.startDuration = startDuration;
		this.endDuration = endDuration;
		this.createdDate = createdDate;
		this.priority = priority;
		this.usersAsignedToActivity = usersAsignedToActivity;
		this.createdBy = createdBy;
		this.stateActivity = stateActivity;
	}
	public ActivityRequestDto() {
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
	
	public List<UserDto> getUsersAsignedToActivity() {
		return usersAsignedToActivity;
	}
	public void setUsersAsignedToActivity(List<UserDto> usersAsignedToActivity) {
		this.usersAsignedToActivity = usersAsignedToActivity;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public StateActivityDto getStateActivity() {
		return stateActivity;
	}
	public void setStateActivity(StateActivityDto stateActivity) {
		this.stateActivity = stateActivity;
	}
	public Long getIdActivity() {
		return idActivity;
	}
	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}


}
