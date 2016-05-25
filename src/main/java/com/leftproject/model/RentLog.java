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
@Table(name="RENT_LOG")
public class RentLog {
	
	@Id
	@Column (name = "RENT_LOG_ID")
	private int rentLogId;
	
	@Column (name = "RENT_CODE")
	@Size ( min = 9 , max = 9)
	private String rentCode;
	
    @Column(name="RENT_DATE_START")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date rentDateStart;
    
    @Column(name="RENT_DATE_END")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date rentDateEnd;
    
    @Column(name="RENT_PRICE")
	private Long rentPrice;
    
    @Column(name="RENT_STATUS")
    @Size(min=1,max=1)
	private String rentStatus;
    
    @Column (name = "RENT_PHASE")
    @Size(min=1,max=1)
    private String rentPhase;
    
    @Column(name="RENT_LETTER_PATH")
    @Size(max = 100)
	private String rentLetterPath;
    
    @Column(name="RENT_EVIDANCE_PATH")
	private Long rentEvidancePath;
    
    @Column(name="RENT_REJECT_REASON")
	private String rentRejectReason;
    
    @Column(name="UPDATED_BY")
    @Size(min=50,max=50)
	private String updatedBy;
    
    @Column(name="UPDATED_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date updatedDate;

	public RentLog(int rentLogId, String rentCode, Date rentDateStart, Date rentDateEnd, long rentPrice, String rentStatus,
			String rentPhase, String rentLetterPath, long rentEvidancePath, String rentRejectReason, String updatedBy,
			Date updatedDate) {
		super();
		this.rentLogId = rentLogId;
		this.rentCode = rentCode;
		this.rentDateStart = rentDateStart;
		this.rentDateEnd = rentDateEnd;
		this.rentPrice = rentPrice;
		this.rentStatus = rentStatus;
		this.rentPhase = rentPhase;
		this.rentLetterPath = rentLetterPath;
		this.rentEvidancePath = rentEvidancePath;
		this.rentRejectReason = rentRejectReason;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getRentLogId() {
		return rentLogId;
	}

	public void setRentLogId(int rentLogId) {
		this.rentLogId = rentLogId;
	}

	public String getRentCode() {
		return rentCode;
	}

	public void setRentCode(String rentCode) {
		this.rentCode = rentCode;
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

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}

	public String getRentPhase() {
		return rentPhase;
	}

	public void setRentPhase(String rentPhase) {
		this.rentPhase = rentPhase;
	}

	public String getRentLetterPath() {
		return rentLetterPath;
	}

	public void setRentLetterPath(String rentLetterPath) {
		this.rentLetterPath = rentLetterPath;
	}

	public long getRentEvidancePath() {
		return rentEvidancePath;
	}

	public void setRentEvidancePath(long rentEvidancePath) {
		this.rentEvidancePath = rentEvidancePath;
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

	
