package com.websystique.springmvc.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.*;

@Repository("FacilityDao")
public class FacilityDaoImpl extends AbstractDao<Integer, Facility> implements FacilityDao{
	
	
	public List<Facility> getFacilityList()
	{
		Criteria criteria = createEntityCriteria();
		return (List<Facility>) criteria.list();
	}
	
	
	public Facility getFacility(int facility_id)
	{
		return getByKey(facility_id);
	}
}
