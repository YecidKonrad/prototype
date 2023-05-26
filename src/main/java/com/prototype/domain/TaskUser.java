package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="task_user")
public class TaskUser implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	UserTaskKey idUserTaskKey = new UserTaskKey();

	@ManyToOne
	@MapsId("idTask")
	@JoinColumn(name = "id_task", nullable = false, foreignKey = @ForeignKey(name = "fk_task_user_task"))
	private Task task;
	
	@ManyToOne
	@MapsId("idUser")
	@JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "fk_task_user_user"))
	private User user;

	public TaskUser(Task task, User user) {
		this.task = task;
		this.user = user;
	}

	public TaskUser() {
	}
	

	public UserTaskKey getIdUserTaskKey() {
		return idUserTaskKey;
	}

	public void setIdUserTaskKey(UserTaskKey idUserTaskKey) {
		this.idUserTaskKey = idUserTaskKey;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
