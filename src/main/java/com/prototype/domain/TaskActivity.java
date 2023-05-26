package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="task_activity")
public class TaskActivity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	TaskActivityKey idTaskActivityKey = new TaskActivityKey();
	
	@ManyToOne
	@MapsId("idActivity")
	@JoinColumn(name = "id_activity", nullable = false, foreignKey = @ForeignKey(name = "fk_task_activity_activity"))
	private Activity activity;
	
	@ManyToOne
	@MapsId("idTask")
	@JoinColumn(name = "id_task", nullable = false, foreignKey = @ForeignKey(name = "fk_task_activity_task"))
	private Task task;

	public TaskActivity(Activity activity, Task task) {
		this.activity = activity;
		this.task = task;
	}

	public TaskActivity() {
	}

	public TaskActivityKey getIdTaskActivityKey() {
		return idTaskActivityKey;
	}

	public void setIdTaskActivityKey(TaskActivityKey idTaskActivityKey) {
		this.idTaskActivityKey = idTaskActivityKey;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	
}
