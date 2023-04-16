package com.prototype.utility;

import org.apache.commons.lang3.StringUtils;

public class Utilities {

	public static boolean isNotBlankAndTheSame(String object1, String object2) {
		if (StringUtils.isNotBlank(object1) && object1.equalsIgnoreCase(object2)) {
			return true;
		}
		return false;
	}
	

}
