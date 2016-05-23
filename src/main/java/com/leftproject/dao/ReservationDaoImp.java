package com.leftproject.dao;

import java.util.List;

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

	
	//yg dari sequence appl
	@SuppressWarnings("unchecked")
	public List<Reservation> getAllReservations(User user){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userCode", user.getUserCode()));
		return (List<Reservation>) criteria.list();
	}
	
	public String cancelReservation(Reservation reservation){
		Query query = getSession().createSQLQuery("delete from RESERVATION where reservation_id = " + reservation.getReservationCode());
		query.executeUpdate();
		return "Pembatalan peminjaman ruangan berhasil";
	}
	
	public void saveReservation(Reservation reservation) {
		persist(reservation);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reservation> getProposedMovementReservation(){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("reservation_phase", "M"));
		return (List<Reservation>) criteria.list();
	}
	
	public String approveReservationByRoomManager(Reservation reservation){
		reservation.setReservationPhase("4");
		persist(reservation);
		return "Peminjaman rungan telah disetujui";
	}
	
	public String approveReservationByKaSubbagTU(Reservation reservation){
		reservation.setReservationPhase("3");
		persist(reservation);
		return "Peminjaman rungan telah disetujui";
	}
	
	public String denyReservation(Reservation reservation){
		return "success";
		//return success message
	}
	public String denyReservationByRoomManager(Reservation reservation){
		reservation.setReservationPhase("5");
		persist(reservation);
		return "Pengajuan pemindahan jadwal atau ruang peminjaman tidak diizinkan Pengelola Ruang Khusus";
	}
	
	public String denyReservationByKasubbagTU(Reservation reservation){
		reservation.setReservationPhase("6");
		persist(reservation);
		return "Pengajuan pemindahan jadwal atau ruang peminjaman tidak diizinkan Kasubbag TU";
	}
	
}
