package com.prototype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prototype.domain.Activity;
import com.prototype.domain.Task;
import com.prototype.domain.TaskActivity;
import com.prototype.domain.TaskActivityKey;

public interface TaskActivityRepository extends JpaRepository<TaskActivity, TaskActivityKey> {

	List<TaskActivity> findTaskActivityByActivity(Activity activity);
	@Query("Select ta from TaskActivity ta where ta.task = ?1")
	List<TaskActivity> findTasksActivityByTask(Task task);

}
