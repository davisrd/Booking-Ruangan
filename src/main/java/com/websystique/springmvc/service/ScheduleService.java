package com.websystique.springmvc.service;

import java.util.Date;

import com.leftproject.model.Schedule;

public interface ScheduleService {
	
	public int roomStatus(String roomId, Date startDate, Date endDate);
	Schedule getSchedule(String roomId, Date date);
}
