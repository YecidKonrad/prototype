package com.prototype.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.prototype.domain.User;

public class PhaseRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phase;
	private Date startDuration;
	private Date endDuration;
	private String description;
	private int ordering;
	private StatePhaseDto statePhase;
	private List<UserDto> usersAsignedToPhase;
	private User createdBy;
	private List<ActivityRequestDto> activitiesAsingPhase;	
	
	public PhaseRequestDto() {
	}	
	public PhaseRequestDto(String phase, Date startDuration, Date endDuration, String description, int ordering,
			StatePhaseDto statePhase, List<UserDto> usersAsignedToPhase, User createdBy,
			List<ActivityRequestDto> activitiesAsingPhase) {
		this.phase = phase;
		this.startDuration = startDuration;
		this.endDuration = endDuration;
		this.description = description;
		this.ordering = ordering;
		this.statePhase = statePhase;
		this.usersAsignedToPhase = usersAsignedToPhase;
		this.createdBy = createdBy;
		this.activitiesAsingPhase = activitiesAsingPhase;
	}
	

	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOrdering() {
		return ordering;
	}
	public void setOrdering(int ordering) {
		this.ordering = ordering;
	}
	
	public StatePhaseDto getStatePhase() {
		return statePhase;
	}

	public void setStatePhase(StatePhaseDto statePhase) {
		this.statePhase = statePhase;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<ActivityRequestDto> getActivitiesAsingPhase() {
		return activitiesAsingPhase;
	}

	public void setActivitiesAsingPhase(List<ActivityRequestDto> activitiesAsingPhase) {
		this.activitiesAsingPhase = activitiesAsingPhase;
	}
	public List<UserDto> getUsersAsignedToPhase() {
		return usersAsignedToPhase;
	}
	public void setUsersAsignedToPhase(List<UserDto> usersAsignedToPhase) {
		this.usersAsignedToPhase = usersAsignedToPhase;
	}
}
