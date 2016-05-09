package com.websystique.springmvc.service;

import java.util.Date;

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
	
	public int roomStatus(String roomId, Date startDate, Date endDate){
		return dao.roomStatus(roomId, startDate, endDate);
	}
	
	public Schedule getSchedule(String roomId, Date date){
		return dao.getSchedule(roomId,date);
	}
}
