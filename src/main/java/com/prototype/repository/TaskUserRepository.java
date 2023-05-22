package com.prototype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.Task;
import com.prototype.domain.TaskUser;

public interface TaskUserRepository extends JpaRepository<TaskUser, TaskUserRepository> {

	public List<TaskUser> findTaskUserByTask(Task task);
}
