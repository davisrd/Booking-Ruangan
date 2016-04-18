package com.leftproject.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name="RESERVATION_ID")
	private String reservationId;
    
    @Column(name="RESERVATION_DATE_START")
	private Date reservationDateStart;

    @Column(name="RESERVATION_DATE_END")
	private Date reservationDateEnd;

    @Column(name="RESERVATION_STATUS")
	private boolean reservationStatus;
    
    @Column(name="RESERVATION_FILE_PATH")
	private String reservationFilePath;

    @Column(name="RESERVATION_OPERATIONAL_PRICE")
	private long reservationOperationalPrice;
    
    @Column(name="RESERVATION_REJECT_REASON")
	private String reservationRejectReason;
    
    @Column(name="EVENT_TYPE")
	private String eventType;
    
    @Column(name="EVENT_NAME")
	private String eventName;
    
    @Column(name="EVENT_SCALE")
	private String eventScale;
    
    @Column(name="EVENT_TOTAL_PARTICIPANT")
	private int eventTotalParticipant;
    
    @Column(name="CREATED_DATE")
	private Date createdDate;
    
    @Column(name="UPDATED_BY")
	private String updatedBy;
    
    @Column(name="UPDATED_DATE")
	private Date updatedDate;

	private User user;
	
	private Facility facility;
	
	private Set<ReservationDisposition> reservationDispositionList;
	private Set<ReservationLog> reservationLogList;
	private Set<ReservationMemorandum> reservationMemorandumList;
	
	public Reservation(String reservationId, Date reservationDateStart, Date reservationDateEnd,
			boolean reservationStatus, String reservationFilePath, long reservationOperationalPrice,
			String reservationRejectReason, String eventType, String eventName, String eventScale,
			int eventTotalParticipant, Date createdDate, String updatedBy, Date updatedDate, User user,
			Facility facility, Set<ReservationDisposition> reservationDispositionList,
			Set<ReservationLog> reservationLogList, Set<ReservationMemorandum> reservationMemorandumList) {
		super();
		this.reservationId = reservationId;
		this.reservationDateStart = reservationDateStart;
		this.reservationDateEnd = reservationDateEnd;
		this.reservationStatus = reservationStatus;
		this.reservationFilePath = reservationFilePath;
		this.reservationOperationalPrice = reservationOperationalPrice;
		this.reservationRejectReason = reservationRejectReason;
		this.eventType = eventType;
		this.eventName = eventName;
		this.eventScale = eventScale;
		this.eventTotalParticipant = eventTotalParticipant;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.user = user;
		this.facility = facility;
		this.reservationDispositionList = reservationDispositionList;
		this.reservationLogList = reservationLogList;
		this.reservationMemorandumList = reservationMemorandumList;
	}
	//Getter dan Setter
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
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
	public boolean isReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(boolean reservationStatus) {
		this.reservationStatus = reservationStatus;
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
	public String getEventScale() {
		return eventScale;
	}
	public void setEventScale(String eventScale) {
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
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public Set<ReservationDisposition> getReservationDispositionList() {
		return reservationDispositionList;
	}
	public void setReservationDispositionList(Set<ReservationDisposition> reservationDispositionList) {
		this.reservationDispositionList = reservationDispositionList;
	}
	public Set<ReservationLog> getReservationLogList() {
		return reservationLogList;
	}
	public void setReservationLogList(Set<ReservationLog> reservationLogList) {
		this.reservationLogList = reservationLogList;
	}
	public Set<ReservationMemorandum> getReservationMemorandumList() {
		return reservationMemorandumList;
	}
	public void setReservationMemorandumList(Set<ReservationMemorandum> reservationMemorandumList) {
		this.reservationMemorandumList = reservationMemorandumList;
	}
	
	
}
