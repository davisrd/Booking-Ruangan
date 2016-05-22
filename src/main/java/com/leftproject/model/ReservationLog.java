package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="RESERVATION_LOG")
public class ReservationLog {
    
	
    @Column(name="RESERVATION_DATE_START")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date resDateStart;
    
    @Column(name="RESERVATION_DATE_END")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date resDateEnd;
    
    @Column(name="RESERVATION_STATUS")
	private char resStatus;
    
    @Column(name="RESERVATION_PHASE")
   	private char resPhase;
    
    
    @Column(name="RESERVATION_OPERATIONAL_PRICE")
	private long resOperationalPrice;
    
    @Column(name="RESERVATION_FILE_PATH")
	private String resFilePath;
    
    @Column(name="RESERVATION_REJECT_REASON")
	private String rentRejectReason;
    
    @Column(name="UPDATED_BY")
	private String updatedBy;
    
    @Column(name="UPDATED_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date updatedDate;

	public ReservationLog(Date resDateStart, Date resDateEnd, char resStatus, char resPhase, long resOperationalPrice,
			String resFilePath, String rentRejectReason, String updatedBy, Date updatedDate) {
		super();
		this.resDateStart = resDateStart;
		this.resDateEnd = resDateEnd;
		this.resStatus = resStatus;
		this.resPhase = resPhase;
		this.resOperationalPrice = resOperationalPrice;
		this.resFilePath = resFilePath;
		this.rentRejectReason = rentRejectReason;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public Date getResDateStart() {
		return resDateStart;
	}

	public void setResDateStart(Date resDateStart) {
		this.resDateStart = resDateStart;
	}

	public Date getResDateEnd() {
		return resDateEnd;
	}

	public void setResDateEnd(Date resDateEnd) {
		this.resDateEnd = resDateEnd;
	}

	public char getResStatus() {
		return resStatus;
	}

	public void setResStatus(char resStatus) {
		this.resStatus = resStatus;
	}

	public char getResPhase() {
		return resPhase;
	}

	public void setResPhase(char resPhase) {
		this.resPhase = resPhase;
	}

	public long getResOperationalPrice() {
		return resOperationalPrice;
	}

	public void setResOperationalPrice(long resOperationalPrice) {
		this.resOperationalPrice = resOperationalPrice;
	}

	public String getResFilePath() {
		return resFilePath;
	}

	public void setResFilePath(String resFilePath) {
		this.resFilePath = resFilePath;
	}

	public String getRentRejectReason() {
		return rentRejectReason;
	}

	public void setRentRejectReason(String rentRejectReason) {
		this.rentRejectReason = rentRejectReason;
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
    
    
    
}

	