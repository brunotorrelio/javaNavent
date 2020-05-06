package com.brunotorrelio.testnavent.utils;

import org.springframework.beans.BeanUtils;

public class Utils {
	
	public static Object copyPropertiesObject(Object origin, Object destiny) throws Exception {				
		BeanUtils.copyProperties(origin, destiny);
		return destiny;
	}
	
}
