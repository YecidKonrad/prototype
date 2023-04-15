package com.prototype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.Phase;
import com.prototype.domain.PhaseUser;

public interface PhaseUserRepository extends JpaRepository<PhaseUser, Long> {

	List<PhaseUser> findPhaseUserByPhase(Phase phase);
}
