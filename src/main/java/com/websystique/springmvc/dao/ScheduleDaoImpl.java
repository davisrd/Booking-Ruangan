package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.leftproject.model.Schedule;;

@Repository("ScheduleDao")
public class ScheduleDaoImpl extends AbstractDao<Integer, Schedule> implements ScheduleDao{
	
	public int roomStatus(String facilityId, Date startDate, Date endDate){
		int roomStatus = 0;
		
			List<Schedule> listSchedule = getListSchedule(facilityId, startDate, endDate);
			if(listSchedule.isEmpty()){
				return 0;
			}
			
			
		return roomStatus;
	}
	
	public List<Schedule> getListSchedule(String facilityId, Date startDate, Date endDate){
		Criteria criteria = createEntityCriteria();
		Restrictions res = null;
		criteria.add(res.eq("ID_ROOM", facilityId));
		criteria.add(res.between("DATE_START", startDate, endDate));
		criteria.add(res.between("DATE_END", startDate, endDate));
		return (List<Schedule>) criteria.list();
	}
}
