package com.websystique.springmvc.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leftproject.model.Schedule;
import com.websystique.springmvc.dao.ScheduleDao;

@Service("ScheduleService")
@Transactional
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleDao dao;
	
	public boolean getRentRoomAvailability(String usageCode, Date startDate, Date endDate){
		List<Schedule> schedules = dao.getListSchedule(usageCode, startDate, endDate);
		if(!schedules.isEmpty())
			for(Schedule schedule:schedules)
			{
				if(schedule.getUsageCode().toString().substring(1,2)=="RE")
					return false;
			}
		return true;
	}
	
	public boolean getReservationRoomAvailability(String usageCode, Date startDate, Date endDate){
		List<Schedule> schedules = dao.getListSchedule(usageCode, startDate, endDate);
		if(!schedules.isEmpty())
			for(Schedule schedule:schedules)
			{
				if(schedule.getUsageCode().toString().substring(1,2)=="RS")
					return false;
			}
		return true;
	}
	
	
	public Schedule getSchedule(String usageCode, Date date){
		return dao.getSchedule(usageCode,date);
	}
}
