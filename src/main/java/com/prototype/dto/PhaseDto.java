package com.prototype.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PhaseDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idPhase;
	private String phase;
	private Date startDuration;
	private Date endDuration;
	private Date createdDate;
	private String description;
	private int ordering;
	private StatePhaseDto statePhase;
	private UserDto createdBy;
	private List<UserDto> usersAsignedToPhase;
	private List<ActivityDto> activitiesAsingPhase;
	
	public PhaseDto() {
	}

	public PhaseDto(Long idPhase, String phase, Date startDuration, Date endDuration, Date createdDate,
			String description, int ordering, StatePhaseDto statePhase, UserDto createdBy,
			List<UserDto> usersAsignedToPhase, List<ActivityDto> activitiesAsingPhase) {
		this.idPhase = idPhase;
		this.phase = phase;
		this.startDuration = startDuration;
		this.endDuration = endDuration;
		this.createdDate = createdDate;
		this.description = description;
		this.ordering = ordering;
		this.statePhase = statePhase;
		this.createdBy = createdBy;
		this.usersAsignedToPhase = usersAsignedToPhase;
		this.activitiesAsingPhase = activitiesAsingPhase;
	}

	public Long getIdPhase() {
		return idPhase;
	}

	public void setIdPhase(Long idPhase) {
		this.idPhase = idPhase;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public UserDto getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDto createdBy) {
		this.createdBy = createdBy;
	}

	public List<UserDto> getUsersAsignedToPhase() {
		return usersAsignedToPhase;
	}

	public void setUsersAsignedToPhase(List<UserDto> usersAsignedToPhase) {
		this.usersAsignedToPhase = usersAsignedToPhase;
	}

	public List<ActivityDto> getActivitiesAsingPhase() {
		return activitiesAsingPhase;
	}

	public void setActivitiesAsingPhase(List<ActivityDto> activitiesAsingPhase) {
		this.activitiesAsingPhase = activitiesAsingPhase;
	}
	
	

}
