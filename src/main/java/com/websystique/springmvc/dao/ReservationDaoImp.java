package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Rent;
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
	
	private String getCurrentLastId(String mmYY)
	{
		String reservationCode;
		Query query = getSession().createQuery("from Reservation where substring(reservation_code,3,4)='"+mmYY+"' order by reservation_code DESC");
		query.setMaxResults(1);
		List<Reservation> reservations = query.list();
		Reservation reservation = new Reservation();
		if(!reservations.isEmpty())
		{
			 reservation = reservations.get(0);
			 reservationCode = reservation.getReservationCode().substring(0, 6);
			 int id = Integer.parseInt(reservation.getReservationCode().substring(6, 9));
			 id++;
			 reservationCode = reservationCode + String.format("%03d", id);
		}
		else
		{
			reservationCode = "RS"+mmYY+"001";
		}
		return reservationCode;
	}
	
	@SuppressWarnings("unchecked")
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
	
	public Reservation getReservationByCode(String reservationCode){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("reservationCode", reservationCode));
		return (Reservation) criteria.uniqueResult();
	}

	
	//yg dari sequence appl
	@SuppressWarnings("unchecked")
	public List<Reservation> getAllReservation(User user){
		Criteria criteria = createEntityCriteria();
//		criteria.add(Restrictions.eq("userCode", user.getUserCode()));
		criteria.createCriteria("user")
			.add(Restrictions.eq("userCode", user.getUserCode()));
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
			reservation.setReservationCode(this.getCurrentLastId(dateToYYMM(reservation.getReservationDateStart())));
			persist(reservation);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Reservation> getProposedMovementReservation(){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("reservationPhase", "M"));
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