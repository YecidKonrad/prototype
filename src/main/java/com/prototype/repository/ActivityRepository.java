package com.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {


}
