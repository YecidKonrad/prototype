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
	private Long idStatePhase;
	private Map<Long, String> usersAsingPhase;
	private User createdBy;
	private List<ActivityRequestDto> activitiesAsingPhase;
	
	
	
	public PhaseRequestDto() {
	}
	
	
	
	public PhaseRequestDto(String phase, Date startDuration, Date endDuration, String description, int ordering,
			Long idStatePhase, Map<Long, String> usersAsingPhase, User createdBy) {
		this.phase = phase;
		this.startDuration = startDuration;
		this.endDuration = endDuration;
		this.description = description;
		this.ordering = ordering;
		this.idStatePhase = idStatePhase;
		this.usersAsingPhase = usersAsingPhase;
		this.createdBy = createdBy;
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
	public Long getIdStatePhase() {
		return idStatePhase;
	}
	public void setIdStatePhase(Long idStatePhase) {
		this.idStatePhase = idStatePhase;
	}
	public Map<Long, String> getUsersAsingPhase() {
		return usersAsingPhase;
	}
	public void setUsersAsingPhase(Map<Long, String> usersAsingPhase) {
		this.usersAsingPhase = usersAsingPhase;
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
	
	
}
