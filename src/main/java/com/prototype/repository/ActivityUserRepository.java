package com.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.ActivityUser;

public interface ActivityUserRepository extends JpaRepository<ActivityUser, Long> {


}
