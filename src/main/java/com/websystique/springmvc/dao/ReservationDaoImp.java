package com.websystique.springmvc.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Reservation;

@Repository("ReservationDao")
public class ReservationDaoImp extends AbstractDao<Integer, Reservation> implements ReservationDao {

	public void saveReservation(Reservation employee) {
		persist(employee);
	}

	public void deleteReservationById(int nip) {
		Query query = getSession().createSQLQuery("delete from Peminjaman where idPeminjaman = " + nip);
//		query.setString("nip", nip);
		query.executeUpdate();
	}
	
	public List<Reservation> getProposedReservation(){
		Criteria criteria = createEntityCriteria();
		return (List<Reservation>) criteria.list();
	}
	
/*	public Reservation getReservationByRoomId(String roomId){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ROOMID", roomId));
		return ((List<Reservation>) criteria.list()).get(0);
	}*/
	
	public Reservation getReservation(String reservationId){
		return getByKey(reservationId);
	}
	/*	@SuppressWarnings("unchecked")
	public List<Reservation> findAllPeminjamans() {
		Criteria criteria = createEntityCriteria();
		return (List<Reservation>) criteria.list();
	}*/

	
}
