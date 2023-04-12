package com.prototype.service;

import com.prototype.dto.ActivityRequestDto;
import com.prototype.dto.ActivityResponseDto;

public interface ActivityService {

	ActivityResponseDto create(ActivityRequestDto activityRequestDto, String userTokenHeder);
   
}
