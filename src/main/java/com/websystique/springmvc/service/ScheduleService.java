package com.websystique.springmvc.service;

import java.util.Date;

import com.leftproject.model.Schedule;

public interface ScheduleService {
	public boolean getRoomStatus(int roomId, Date startDate, Date endDate);
	Schedule getSchedule(int roomId, Date date);
}
