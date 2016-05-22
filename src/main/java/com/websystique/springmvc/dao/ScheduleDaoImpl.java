package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.*;
import com.leftproject.model.Reservation;
import com.leftproject.model.Schedule;;

@Repository("ScheduleDao")
public class ScheduleDaoImpl extends AbstractDao<Integer, Schedule> implements ScheduleDao{
	ReservationDao dao;
	public boolean getRoomStatus(int roomId, Date startDate, Date endDate){
			
			List<Schedule> listSchedule = getListSchedule(roomId, startDate, endDate);
			if(listSchedule.isEmpty()){
				return true;
			}
			else if(listSchedule.get(0).getIdRoomUsage().toString().substring(0, 1)=="RS"){
				Schedule schedule = listSchedule.get(0);
				Reservation reservation = dao.getReservation(schedule.getIdRoomUsage().toString());
				if(reservation.getEventType().toUpperCase()=="AKADEMIK") return false;
			}
			else if(listSchedule.get(0).getIdRoomUsage().toString().substring(0, 1)=="RE") return false;
			
			
		return false;
	}
	
	public List<Schedule> getListSchedule(int roomId, Date startDate, Date endDate){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("idRoom", roomId));
		criteria.add(Restrictions.between("dateStart", startDate, endDate));
		criteria.add(Restrictions.between("dateEnd", startDate, endDate));
		return (List<Schedule>) criteria.list();
	}
	
	public Schedule getSchedule(int roomId, Date date){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("idRoom", roomId));
//		criteria.add(res.like("dateStart", new Date(date.getYear(),date.getMonth(),date.getDate()) ));
		return (Schedule) criteria.list();
	}
}
