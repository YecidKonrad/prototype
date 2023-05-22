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


}
