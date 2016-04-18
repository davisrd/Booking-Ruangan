package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Facility;
import com.websystique.springmvc.dao.FacilityDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("FacilityService")
@Transactional
public class FacilityServiceImpl implements FacilityService{
	
	@Autowired
	private FacilityDao facilityDao;
	
	public List<Facility> getFacilityList()
	{
		return facilityDao.getFacilityList();
	}
	
	public Facility getFacility(int facility_id)
	{
		return facilityDao.getFacility(facility_id);
	}
}
