package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.*;

@Repository("ScheduleDao")
public class ScheduleDaoImpl extends AbstractDao<Integer, Schedule> implements ScheduleDao{
	ReservationDao dao;
	public boolean getRoomAvailability(String usageId, Date startDate, Date endDate){
			
			List<Schedule> listSchedule = getListSchedule(usageId, startDate, endDate);
			if(listSchedule.isEmpty()){
				return true;
			}
			else 
				return false;
	}

	@SuppressWarnings("unchecked")
	public List<Schedule> getListSchedule(String usageCode, Date startDate, Date endDate){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("usageCode", usageCode));
		criteria.add(Restrictions.between("dateStart", startDate, endDate));
		criteria.add(Restrictions.between("dateEnd", startDate, endDate));
		return (List<Schedule>) criteria.list();
	}
	
	public Schedule getSchedule(String usageCode, Date date){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("usageCode", usageCode));
//		criteria.add(res.like("dateStart", new Date(date.getYear(),date.getMonth(),date.getDate()) ));
		return (Schedule) criteria.list();
	}
}
