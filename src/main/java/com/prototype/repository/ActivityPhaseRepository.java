package com.prototype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.ActivityPhase;
import com.prototype.domain.ActivityPhaseKey;
import com.prototype.domain.Phase;

public interface ActivityPhaseRepository extends JpaRepository<ActivityPhase, ActivityPhaseKey> {

	List<ActivityPhase> findActivityPhaseByPhase(Phase phase);
}
