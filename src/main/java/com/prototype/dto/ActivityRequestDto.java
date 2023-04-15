package com.prototype.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.prototype.domain.User;

public class ActivityRequestDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tittle;
	private String description;
	private Date startDuration;
	private Date endDuration;
	private Date createdDate;
	private int priority;
	private Map<Long, String> usersAsingActivity;
	private User createdBy;
	private Long idStateActivity;
	
	public ActivityRequestDto(String tittle, String description, Date startDuration, Date endDuration, Date createdDate,
			int priority, Map<Long, String> usersAsingActivity, User createdBy, Long idStateActivity) {
		this.tittle = tittle;
		this.description = description;
		this.startDuration = startDuration;
		this.endDuration = endDuration;
		this.createdDate = createdDate;
		this.priority = priority;
		this.usersAsingActivity = usersAsingActivity;
		this.createdBy = createdBy;
		this.idStateActivity = idStateActivity;
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

	public Map<Long, String> getUsersAsingActivity() {
		return usersAsingActivity;
	}

	public void setUsersAsingActivity(Map<Long, String> usersAsingActivity) {
		this.usersAsingActivity = usersAsingActivity;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Long getIdStateActivity() {
		return idStateActivity;
	}

	public void setIdStateActivity(Long idStateActivity) {
		this.idStateActivity = idStateActivity;
	}

	@Override
	public String toString() {
		return "ActivityRequestDto [tittle=" + tittle + ", description=" + description + ", startDuration="
				+ startDuration + ", endDuration=" + endDuration + ", createdDate=" + createdDate + ", priority="
				+ priority + ", usersAsingActivity=" + usersAsingActivity + ", createdBy=" + createdBy
				+ ", idStateActivity=" + idStateActivity + "]";
	}
	
	
	
	

}
