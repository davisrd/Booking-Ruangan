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
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("user_id", user.getuserId()));
		return (List<Reservation>) criteria.list();
	}
	
	public String cancelReservation(Reservation reservation){
		Query query = getSession().createSQLQuery("delete from RESERVATION where reservation_id = " + reservation.getReservationId());
		return "Pembatalan peminjaman ruangan berhasil";
	}
	
	public void saveReservation(Reservation reservation) {
		persist(reservation);
	}
	
	public List<Reservation> getProposedMovementReservation(){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("reservation_phase", "M"));
		return (List<Reservation>) criteria.list();
	}
	
	public String approveReservationByRoomManager(Reservation reservation){
		reservation.setReservationPhase('4');
		persist(reservation);
		return "Peminjaman rungan telah disetujui";
	}
	
	public String approveReservationByKaSubbagTU(Reservation reservation){
		reservation.setReservationPhase('3');
		persist(reservation);
		return "Peminjaman rungan telah disetujui";
	}
	
	public String denyReservationByRoomManager(Reservation reservation){
		reservation.setReservationPhase('5');
		persist(reservation);
		return "Pengajuan pemindahan jadwal atau ruang peminjaman tidak diizinkan Pengelola Ruang Khusus";
	}
	
	public String denyReservationByKasubbagTU(Reservation reservation){
		reservation.setReservationPhase('6');
		persist(reservation);
		return "Pengajuan pemindahan jadwal atau ruang peminjaman tidak diizinkan Kasubbag TU";
	}
	
}
