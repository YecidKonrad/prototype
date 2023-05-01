package com.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.ActivityPhase;

public interface PhaseActivityRepository extends JpaRepository<ActivityPhase, Long> {


}
