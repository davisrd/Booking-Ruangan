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

	@SuppressWarnings("unchecked")
	public List<Schedule> getListSchedule(String roomCode, Date startDate, Date endDate){
		Criteria criteria = createEntityCriteria();
		criteria.createCriteria("room")
			.add(Restrictions.eq("roomCode", roomCode));
		criteria.add(Restrictions.or(
					Restrictions.and
						(Restrictions.le("dateStart", startDate), Restrictions.ge("dateEnd", endDate)),
					Restrictions.and
						(Restrictions.le("dateEnd", startDate), Restrictions.ge("dateEnd", endDate)),
					Restrictions.and
						(Restrictions.le("dateStart", startDate), Restrictions.ge("dateStart", endDate))
					));
		
//		criteria.add(Restrictions.between("dateStart", startDate, endDate));
//		criteria.add(Restrictions.between("dateEnd", startDate, endDate));
		return (List<Schedule>) criteria.list();
	}
	
	public Schedule getSchedule(String roomCode, Date startDate, Date endDate){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("room.roomCode", roomCode));
//		criteria.add(res.like("dateStart", new Date(date.getYear(),date.getMonth(),date.getDate()) ));
		return (Schedule) criteria.uniqueResult();
	}
}
