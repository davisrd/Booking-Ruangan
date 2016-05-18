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

	public void deleteReservationById(int nip) {
		Query query = getSession().createSQLQuery("delete from RESERVATION where idPeminjaman = " + nip);
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

	
	//yg dari sequence appl
	public List<Reservation> getAllReservations(User user){
		Query query = getSession().createSQLQuery("select from RESERVATION where user_id = " + user.userId);
		//return list reservation
	}
	
	public String cancelReservation(Reservation reservation){
		Query query = getSession().createSQLQuery("delete from RESERVATION where reservation_id = " + reservation.reservationId);
		return "Pembatalan peminjaman ruangan berhasil";
	}
	
	public void saveReservation(Reservation reservation) {
		persist(reservation);
	}
	
	public List<Reservation> getProposedMovementReservation(){
		Query query = getSession().createSQLQuery("select from RESERVATION where reservation_status = M");
		//return list reservation
	}
	
	public String approveReservationByRoomManager(Reservation reservation){
		reservation.reservationPhase=4;
		persist(reservation);
		return "Peminjaman rungan telah disetujui";
	}
	
	public String approveReservationByKaSubbagTU(Reservation reservation){
		reservation.reservationPhase=3;
		persist(reservation);
		return "Peminjaman rungan telah disetujui";
	}
	
	public String denyReservation(Reservation reservation){
		
		//return success message
	}
	
	
}
