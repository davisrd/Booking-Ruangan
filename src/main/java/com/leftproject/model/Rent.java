package com.leftproject.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="RENT")
public class Rent {
    @Id
    @Column(name="RENT_CODE")
    @Size(min=9 ,max=9)
    private String rentCode;
    
    @Column (name = "USER_CODE")
	@Size (min = 9 , max = 9)
	private String userCode;
    
    @Column (name = "ROOM_CODE")
	@Size (min = 5 , max = 5)
	private String roomCode;

    @Column(name="RENTER")
    @Size (max =255)
	private String renter;

    @Column(name="RENT_DATE_START")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date rentDateStart;

    @Column(name="RENT_DATE_END")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date rentDateEnd;

    @Column(name="RENT_PRICE")
	private long rentPrice;

    @Column(name="RENT_OPERATIONAL_PRICE")
	private long rentOperationalPrice;

    @Column(name="RENT_STATUS", nullable = false)
    @Size(min=1,max=1)
	private String rentStatus;

    @Column(name="RENT_PHASE", nullable = false)
    @Size(min=1,max=1)
	private String rentPhase;
    
    @Column(name="RENT_LETTER_PATH")
    @Size(max=100)
	private String rentLetterPath;

    @Column(name="RENT_EVIDENCE_PATH")
    @Size(max=100)
	private String rentEvidencePath;

    @Column(name="RENT_REJECT_REASON")
	private String rentRejectReason;
    
    @Column(name="RENT_CANCEL_REASON")
	private String rentCancelReason;

    @Column(name="EVENT_CATEGORY", nullable = false)
    @Size(min=1,max=1)
	private String eventCategory;

    @Column(name="EVENT_NAME")
    @Size(max=25)
	private String eventName;

    @Column(name="CREATED_DATE")
	private Date createdDate;

    @Column(name="UPDATED_BY")
    @Size(min=50,max=50)
	private String updatedBy;

    @Column(name="UPDATED_DATE")
	private Date updatedDate;

    @Column(name="USER_ID")
	private String userId;
	
	@Autowired
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "room_id")
	private Room room;
	
//	@OneToMany(mappedBy="department")
//    @JoinColumn(name="department_id")
//    @IndexColumn(name="idx")
	
	public void setRentPhase(String rentPhase) {
		this.rentPhase = rentPhase;
	}

	public Rent(){
		
	}

	public Rent(String rentCode, String userCode, String roomCode, String renter, Date rentDateStart, Date rentDateEnd,
			long rentPrice, long rentOperationalPrice, String rentStatus, String rentPhase, String rentLetterPath,
			String rentEvidencePath, String rentRejectReason, String rentCancelReason, String eventCategory,
			String eventName, Date createdDate, String updatedBy, Date updatedDate, String userId, Room room) {
		super();
		this.rentCode = rentCode;
		this.userCode = userCode;
		this.roomCode = roomCode;
		this.renter = renter;
		this.rentDateStart = rentDateStart;
		this.rentDateEnd = rentDateEnd;
		this.rentPrice = rentPrice;
		this.rentOperationalPrice = rentOperationalPrice;
		this.rentStatus = rentStatus;
		this.rentPhase = rentPhase;
		this.rentLetterPath = rentLetterPath;
		this.rentEvidencePath = rentEvidencePath;
		this.rentRejectReason = rentRejectReason;
		this.rentCancelReason = rentCancelReason;
		this.eventCategory = eventCategory;
		this.eventName = eventName;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.userId = userId;
		this.room = room;
	}

	public String getRentCode() {
		return rentCode;
	}

	public void setRentCode(String rentCode) {
		this.rentCode = rentCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRenter() {
		return renter;
	}

	public void setRenter(String renter) {
		this.renter = renter;
	}

	public Date getRentDateStart() {
		return rentDateStart;
	}

	public void setRentDateStart(Date rentDateStart) {
		this.rentDateStart = rentDateStart;
	}

	public Date getRentDateEnd() {
		return rentDateEnd;
	}

	public void setRentDateEnd(Date rentDateEnd) {
		this.rentDateEnd = rentDateEnd;
	}

	public long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public long getRentOperationalPrice() {
		return rentOperationalPrice;
	}

	public void setRentOperationalPrice(long rentOperationalPrice) {
		this.rentOperationalPrice = rentOperationalPrice;
	}

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}

	public String getRentLetterPath() {
		return rentLetterPath;
	}

	public void setRentLetterPath(String rentLetterPath) {
		this.rentLetterPath = rentLetterPath;
	}

	public String getRentEvidencePath() {
		return rentEvidencePath;
	}

	public void setRentEvidencePath(String rentEvidencePath) {
		this.rentEvidencePath = rentEvidencePath;
	}

	public String getRentRejectReason() {
		return rentRejectReason;
	}

	public void setRentRejectReason(String rentRejectReason) {
		this.rentRejectReason = rentRejectReason;
	}

	public String getRentCancelReason() {
		return rentCancelReason;
	}

	public void setRentCancelReason(String rentCancelReason) {
		this.rentCancelReason = rentCancelReason;
	}

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
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

	public String getRentPhase() {
		return rentPhase;
	}
	
	
	
}
