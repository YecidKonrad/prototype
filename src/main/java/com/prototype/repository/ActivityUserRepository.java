package com.prototype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.Activity;
import com.prototype.domain.ActivityUser;

public interface ActivityUserRepository extends JpaRepository<ActivityUser, Long> {

	List<ActivityUser> findActivityUserByActivity(Activity activity);
}
