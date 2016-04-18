package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.*;

public interface FacilityDao {
	
	List<Facility> getFacilityList();
	
	Facility getFacility(int facility_id);
}
