package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;
import com.leftproject.model.Schedule;

public interface ScheduleDao {

	public boolean getRoomStatus(String roomId, Date startDate, Date endDate);
	
	public List<Schedule> getListSchedule(String roomId, Date startDate, Date endDate);
	Schedule getSchedule(String roomId, Date date);
}
