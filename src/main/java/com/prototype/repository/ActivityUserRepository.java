package com.prototype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.domain.Activity;
import com.prototype.domain.ActivityUser;
import com.prototype.domain.UserActivityKey;

public interface ActivityUserRepository extends JpaRepository<ActivityUser, UserActivityKey> {

	List<ActivityUser> findActivityUserByActivity(Activity activity);
}
