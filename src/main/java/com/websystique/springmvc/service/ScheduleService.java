package com.websystique.springmvc.service;

import java.util.Date;

public interface ScheduleService {
	
	public int roomStatus(String roomId, Date startDate, Date endDate);
	
}
