package com.websystique.springmvc.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Room;
import com.websystique.springmvc.model.*;

@Repository("FacilityDao")
public class RoomDaoImpl extends AbstractDao<Integer, Room> implements RoomDao{
	
	
	public List<Room> getRoomList()
	{
		Criteria criteria = createEntityCriteria();
		return (List<Room>) criteria.list();
	}
	
	
	public Room getRoom(int facility_id)
	{
		return getByKey(facility_id);
	}
}
