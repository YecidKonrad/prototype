package com.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {


}
