package com.websystique.springmvc.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.ScheduleDao;

@Service("ScheduleService")
public class ScheduleServiceImpl implements ScheduleService{
	private ScheduleDao dao;
	public int roomStatus(String facilityId, Date startDate, Date endDate){
		return dao.roomStatus(facilityId, startDate, endDate);
	}
}
