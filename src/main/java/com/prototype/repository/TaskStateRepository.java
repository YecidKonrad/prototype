package com.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.StateTask;

public interface TaskStateRepository extends JpaRepository<StateTask, Long> {

}
