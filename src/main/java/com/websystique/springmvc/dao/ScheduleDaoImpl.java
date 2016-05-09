package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Reservation;
import com.leftproject.model.Schedule;;

@Repository("ScheduleDao")
public class ScheduleDaoImpl extends AbstractDao<Integer, Schedule> implements ScheduleDao{
	ReservationDao dao;
	public int roomStatus(String roomId, Date startDate, Date endDate){
			
			List<Schedule> listSchedule = getListSchedule(roomId, startDate, endDate);
			if(listSchedule.isEmpty()){
				return 0;
			}
			else if(listSchedule.get(0).getIdRoomUsage().substring(0, 1)=="RS"){
				Reservation reservation = dao.getReservation(roomId);
				if(reservation.getEventType().toUpperCase()=="AKADEMIK") return 1;
			}
			else if(listSchedule.get(0).getIdRoomUsage().substring(0, 1)=="RE") return 1;
			
			
		return 2;
	}
	
	public List<Schedule> getListSchedule(String roomId, Date startDate, Date endDate){
		Criteria criteria = createEntityCriteria();
		Restrictions res = null;
		criteria.add(res.eq("ID_ROOM", roomId));
		criteria.add(res.between("DATE_START", startDate, endDate));
		criteria.add(res.between("DATE_END", startDate, endDate));
		return (List<Schedule>) criteria.list();
	}
	
	public Schedule getSchedule(String roomId, Date date){
		Criteria criteria = createEntityCriteria();
		Restrictions res = null;
		criteria.add(res.eq("ID_ROOM", roomId));
		criteria.add(res.like("DATE_START", new Date(date.getYear(),date.getMonth(),date.getDate()) ));
		return (Schedule) criteria.list();
	}
}
