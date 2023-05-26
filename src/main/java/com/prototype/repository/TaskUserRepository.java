package com.prototype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.Task;
import com.prototype.domain.TaskUser;
import com.prototype.domain.UserTaskKey;

public interface TaskUserRepository extends JpaRepository<TaskUser, UserTaskKey> {

	public List<TaskUser> findTaskUserByTask(Task task);
}
