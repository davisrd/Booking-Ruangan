package com.leftproject.dao;

import java.util.Date;
import java.util.List;
import com.leftproject.model.Schedule;

public interface ScheduleDao {

	public boolean getRoomStatus(String usageCode, Date startDate, Date endDate);
	
	public List<Schedule> getListSchedule(String usageCode, Date startDate, Date endDate);
	
	Schedule getSchedule(String usageCode, Date date);
}
