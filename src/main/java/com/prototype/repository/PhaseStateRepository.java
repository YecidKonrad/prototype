package com.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.StatePhase;

public interface PhaseStateRepository extends JpaRepository<StatePhase, Long> {

}
