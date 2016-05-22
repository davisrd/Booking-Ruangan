package com.leftproject.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.leftproject.model.*;

@Entity
@Table(name="RESERVATION")
public class Reservation {
    @Id
    @Column(name="RESERVATION_ID")
	private int reservationId;
    
    @Id
    @Column(name="RESERVATION_CODE")
    @Size (max = 9)
    private char reservationCode;
    
    @Column(name="RESERVATION_DATE_START")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date reservationDateStart;

    @Column(name="RESERVATION_DATE_END")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date reservationDateEnd;

    @Column(name="RESERVATION_STATUS")
	private char reservationStatus;
    
    @Column(name="RESERVATION_PHASE")
	private char reservationPhase;
    
    @Column(name="RESERVATION_FILE_PATH")
	private String reservationFilePath;

    @Column(name="RESERVATION_OPERATIONAL_PRICE")
	private long reservationOperationalPrice;
    
    @Column(name="RESERVATION_REJECT_REASON")
	private String reservationRejectReason;
    
    @Column(name="RESERVATION_CANCEL_REASON")
	private String reservationCancelReason;
    
    @Column(name="EVENT_TYPE")
	private String eventType;
    
    @Column(name="EVENT_NAME")
	private String eventName;
    
    @Column(name="EVENT_SCALE")
	private char eventScale;
    
    @Column(name="EVENT_TOTAL_PARTICIPANT")
	private int eventTotalParticipant;
    
    @Column(name="CREATED_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date createdDate;
    
    @Column(name="UPDATED_BY")
    @Size (max =50 )
	private char updatedBy;
    
    @Column(name="UPDATED_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date updatedDate;

 
    @Column(name="USER_ID")
	private String userId;
	
	@Autowired
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;
	
	
	
	
	
	public Reservation(int reservationId, char reservationCode, Date reservationDateStart, Date reservationDateEnd,
			char reservationStatus, char reservationPhase, String reservationFilePath, long reservationOperationalPrice,
			String reservationRejectReason, String reservationCancelReason, String eventType, String eventName,
			char eventScale, int eventTotalParticipant, Date createdDate, char updatedBy, Date updatedDate,
			String userId, Room room) {
		super();
		this.reservationId = reservationId;
		this.reservationCode = reservationCode;
		this.reservationDateStart = reservationDateStart;
		this.reservationDateEnd = reservationDateEnd;
		this.reservationStatus = reservationStatus;
		this.reservationPhase = reservationPhase;
		this.reservationFilePath = reservationFilePath;
		this.reservationOperationalPrice = reservationOperationalPrice;
		this.reservationRejectReason = reservationRejectReason;
		this.reservationCancelReason = reservationCancelReason;
		this.eventType = eventType;
		this.eventName = eventName;
		this.eventScale = eventScale;
		this.eventTotalParticipant = eventTotalParticipant;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.userId = userId;
		this.room = room;
	}





	public int getReservationId() {
		return reservationId;
	}





	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}





	public char getReservationCode() {
		return reservationCode;
	}





	public void setReservationCode(char reservationCode) {
		this.reservationCode = reservationCode;
	}





	public Date getReservationDateStart() {
		return reservationDateStart;
	}





	public void setReservationDateStart(Date reservationDateStart) {
		this.reservationDateStart = reservationDateStart;
	}





	public Date getReservationDateEnd() {
		return reservationDateEnd;
	}





	public void setReservationDateEnd(Date reservationDateEnd) {
		this.reservationDateEnd = reservationDateEnd;
	}





	public char getReservationStatus() {
		return reservationStatus;
	}





	public void setReservationStatus(char reservationStatus) {
		this.reservationStatus = reservationStatus;
	}





	public char getReservationPhase() {
		return reservationPhase;
	}





	public void setReservationPhase(char reservationPhase) {
		this.reservationPhase = reservationPhase;
	}





	public String getReservationFilePath() {
		return reservationFilePath;
	}





	public void setReservationFilePath(String reservationFilePath) {
		this.reservationFilePath = reservationFilePath;
	}





	public long getReservationOperationalPrice() {
		return reservationOperationalPrice;
	}





	public void setReservationOperationalPrice(long reservationOperationalPrice) {
		this.reservationOperationalPrice = reservationOperationalPrice;
	}





	public String getReservationRejectReason() {
		return reservationRejectReason;
	}





	public void setReservationRejectReason(String reservationRejectReason) {
		this.reservationRejectReason = reservationRejectReason;
	}





	public String getReservationCancelReason() {
		return reservationCancelReason;
	}





	public void setReservationCancelReason(String reservationCancelReason) {
		this.reservationCancelReason = reservationCancelReason;
	}





	public String getEventType() {
		return eventType;
	}





	public void setEventType(String eventType) {
		this.eventType = eventType;
	}





	public String getEventName() {
		return eventName;
	}





	public void setEventName(String eventName) {
		this.eventName = eventName;
	}





	public char getEventScale() {
		return eventScale;
	}





	public void setEventScale(char eventScale) {
		this.eventScale = eventScale;
	}





	public int getEventTotalParticipant() {
		return eventTotalParticipant;
	}





	public void setEventTotalParticipant(int eventTotalParticipant) {
		this.eventTotalParticipant = eventTotalParticipant;
	}





	public Date getCreatedDate() {
		return createdDate;
	}





	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}





	public char getUpdatedBy() {
		return updatedBy;
	}





	public void setUpdatedBy(char updatedBy) {
		this.updatedBy = updatedBy;
	}





	public Date getUpdatedDate() {
		return updatedDate;
	}





	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}





	public String getUserId() {
		return userId;
	}





	public void setUserId(String userId) {
		this.userId = userId;
	}





	public Room getRoom() {
		return room;
	}





	public void setRoom(Room room) {
		this.room = room;
	}





	public Reservation() {
		super();
		
		this.reservationDateStart = null;
		this.reservationDateEnd = null;
		this.reservationStatus = 'N';
		this.reservationFilePath = null;
		this.reservationOperationalPrice = 0;
		this.reservationRejectReason = null;
		this.eventType = null;
		this.eventName = null;
		this.eventScale = '\0';
		this.eventTotalParticipant = 0;
		this.createdDate = null;
		this.updatedBy = '\0';
		this.updatedDate = null;
		this.userId = null;
		this.room = null;
	}
	
}
