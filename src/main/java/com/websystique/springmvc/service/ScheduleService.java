package com.websystique.springmvc.service;

import java.util.Date;

import com.leftproject.model.Schedule;

public interface ScheduleService {

	public int getReservationRoomAvailability(String usageCode, Date startDate, Date endDate);

	public int getRentRoomAvailability(String usageCode, Date startDate, Date endDate);
	
	Schedule getSchedule(String usageCode, Date startDate, Date endDate);
}
