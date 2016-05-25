package com.websystique.springmvc.service;

import java.util.Date;

import com.leftproject.model.Schedule;

public interface ScheduleService {
	
	public boolean getRentRoomAvailability(String usageCode, Date startDate, Date endDate);
	
	public boolean getReservationRoomAvailability(String usageCode, Date startDate, Date endDate);
	
	Schedule getSchedule(String usageCode, Date date);
}
