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
    
	 @Id
	    @GeneratedValue
	    @Column(name="RESERVATION_LOG_ID")
	    private int resLogId;
	    
	    
	    @Column(name="RESERVATION_CODE")
	    @Size(min=9 ,max=9)
	    private String resCode;
	
    @Column(name="RESERVATION_DATE_START")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date resDateStart;
    
    @Column(name="RESERVATION_DATE_END")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date resDateEnd;
    
    @Column(name="RESERVATION_STATUS")
    @Size (max = 1 , min =1)
	private String resStatus;
    
    @Column(name="RESERVATION_PHASE")
    @Size (max = 1 , min =1)
   	private String resPhase;
    
    
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

	public ReservationLog(int resLogId, String resCode, Date resDateStart, Date resDateEnd, String resStatus,
			String resPhase, long resOperationalPrice, String resFilePath, String rentRejectReason, String updatedBy,
			Date updatedDate) {
		super();
		this.resLogId = resLogId;
		this.resCode = resCode;
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

	public int getResLogId() {
		return resLogId;
	}

	public void setResLogId(int resLogId) {
		this.resLogId = resLogId;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
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

	public String getResStatus() {
		return resStatus;
	}

	public void setResStatus(String resStatus) {
		this.resStatus = resStatus;
	}

	public String getResPhase() {
		return resPhase;
	}

	public void setResPhase(String resPhase) {
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

	