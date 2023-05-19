package com.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.StateActivity;

public interface ActivityStateRepository extends JpaRepository<StateActivity, Long>{

}
