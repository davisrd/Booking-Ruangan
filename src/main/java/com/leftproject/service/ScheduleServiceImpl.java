package com.leftproject.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leftproject.dao.ScheduleDao;
import com.leftproject.model.Schedule;

@Service("ScheduleService")
@Transactional
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleDao dao;
	
	public int getReservationRoomAvailability(String usageCode, Date startDate, Date endDate){
		List<Schedule> schedules = dao.getListSchedule(usageCode, startDate, endDate);
		if(!schedules.isEmpty()){
			for(Schedule schedule:schedules)
			{
				//System.out.println("Geus aya nu : " + schedule.getUsageStatus());
				if(schedule.getUsageStatus()=="1" || schedule.getUsageStatus()=="3")
					return 3;
			}
			return 2;
		} else {
			//System.out.println("Can aya nu minjem");
			return 1;
		}
	}
	
	public int getRentRoomAvailability(String usageCode, Date startDate, Date endDate){
		List<Schedule> schedules = dao.getListSchedule(usageCode, startDate, endDate);
		if(!schedules.isEmpty()){
			return 2;
		}
		return 1;
	}
	
	public Schedule getSchedule(String usageCode, Date startDate, Date endDate){
		return dao.getSchedule(usageCode ,startDate, endDate);
	}
	
	public void saveSchedule(Schedule schedule){
		dao.saveSchedule(schedule);
	}
}
