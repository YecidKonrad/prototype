package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TaskActivityKey implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Column(name = "id_activity")
	private Long idActivity;

	@Column(name = "id_task")
	private Long idTask;	

	public TaskActivityKey() {
	}

	public TaskActivityKey(Long idActivity, Long idTask) {
		this.idActivity = idActivity;
		this.idTask = idTask;
	}

	public Long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}

	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}

	
	
}
