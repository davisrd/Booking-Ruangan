package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;
import com.leftproject.model.Schedule;

public interface ScheduleDao {

	public int roomStatus(String facilityId, Date startDate, Date endDate);
	
	public List<Schedule> getListSchedule(String facilityId, Date startDate, Date endDate);
}
