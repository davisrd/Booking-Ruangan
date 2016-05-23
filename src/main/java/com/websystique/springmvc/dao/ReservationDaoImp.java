package com.websystique.springmvc.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Reservation;
import com.leftproject.model.User;

@Repository("ReservationDao")
public class ReservationDaoImp extends AbstractDao<Integer, Reservation> implements ReservationDao {

	public boolean deleteReservationById(int nip) {
		try{
			Query query = getSession().createSQLQuery("delete from RESERVATION where idPeminjaman = " + nip);
			query.executeUpdate();
			return true;
		}
		catch (Exception e){
		//	System.out.println(e.toString());
			return false;
		}		
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

	
	//yg dari sequence appl
	public List<Reservation> getAllReservations(User user){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("user_id", user.getUserCode()));
		return (List<Reservation>) criteria.list();
	}
	
	public boolean cancelReservation(Reservation reservation){
		try{
			Query query = getSession().createSQLQuery("delete from RESERVATION where reservation_id = " + reservation.getReservationCode());
			query.executeUpdate();
			return true;
		}
		catch(Exception e){
			return false;
		}		
	}
	
	public boolean saveReservation(Reservation reservation) {
		try{
			persist(reservation);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public List<Reservation> getProposedMovementReservation(){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("reservation_phase", "M"));
		return (List<Reservation>) criteria.list();
	}
	
	public boolean approveReservationByRoomManager(Reservation reservation){
		try{
			reservation.setReservationPhase("4");
			persist(reservation);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean approveReservationByKaSubbagTU(Reservation reservation){
		try{
			reservation.setReservationPhase("3");
			persist(reservation);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean denyReservationByRoomManager(Reservation reservation){
		try{
			reservation.setReservationPhase("5");
			persist(reservation);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean denyReservationByKasubbagTU(Reservation reservation){
		try{
			reservation.setReservationPhase("6");
			persist(reservation);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
}