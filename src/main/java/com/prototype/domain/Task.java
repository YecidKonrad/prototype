package com.prototype.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tasks")
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long idTask;
	private String tittle;
	private String description;
	private Date startDuration;
	private Date endDuration;
	private Date createdDate;
	@ManyToOne
	@JoinColumn(name = "id_state_task", nullable = false, foreignKey = @ForeignKey(name = "fk_task_state_task"))
	private StateTask stateTask;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "created_by", nullable = false, foreignKey = @ForeignKey(name = "fk_task_user"))
	private User createdBy;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<TaskUser> usuarios;
	
	@OneToMany(mappedBy = "activity")
	@JsonIgnore
	private Set<TaskActivity> activities;	
	
	public Task() {
	}

	public Task(Long idTask, String tittle, String description, Date startDuration, Date endDuration, Date createdDate,
			StateTask stateTask, User createdBy) {
		this.idTask = idTask;
		this.tittle = tittle;
		this.description = description;
		this.startDuration = startDuration;
		this.endDuration = endDuration;
		this.createdDate = createdDate;
		this.stateTask = stateTask;
		this.createdBy = createdBy;
	}

	

	public Task(Long idTask) {
		this.idTask = idTask;
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

	public StateTask getStateTask() {
		return stateTask;
	}

	public void setStateTask(StateTask stateTask) {
		this.stateTask = stateTask;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

		
	
}
