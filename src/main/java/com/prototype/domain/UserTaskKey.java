package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserTaskKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "id_user")
	Long idUser;

	@Column(name = "id_task")
	private Long idTask;

	public UserTaskKey(Long idUser, Long idTask) {
		this.idUser = idUser;
		this.idTask = idTask;
	}

	public UserTaskKey() {
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}

	

}
