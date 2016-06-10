package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.leftproject.model.Schedule;

public interface ScheduleDao {

//	public int getRoomAvailability(String roomCode, Date startDate, Date endDate);

	boolean saveSchedule(Schedule schedule);
	
	public List<Schedule> getListSchedule(String roomCode, Date startDate, Date endDate);
	
	Schedule getSchedule(String roomCode, Date startDate, Date endDate);
	
	void sessionFlush();
}
