package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Facility;

public interface FacilityService {
	
	List<Facility> getFacilityList();
	
	Facility getFacility(int facility_id);
}
