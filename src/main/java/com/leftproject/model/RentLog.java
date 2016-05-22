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
	
    @Column(name="RENT_DATE_START")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date rentDateStart;
    
    @Column(name="RENT_DATE_END")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date rentDateEnd;
    
    @Column(name="RENT_PRICE")
	private long rentPrice;
    
    @Column(name="RENT_STATUS")
    @Size(min=1,max=1)
	private char rentStatus;
    
    @Column (name = "RENT_PHASE")
    @Size(min=1,max=1)
    private char rentPhase;
    
    @Column(name="RENT_LETTER_PATH")
    @Size(max = 100)
	private String rentLetterPath;
    
    @Column(name="RENT_EVIDANCE_PATH")
	private long rentEvidancePath;
    
    @Column(name="RENT_REJECT_REASON")
	private String rentRejectReason;
    
    @Column(name="UPDATED_BY")
    @Size(min=50,max=50)
	private char updatedBy;
    
    @Column(name="UPDATED_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date updatedDate;

	public RentLog(Date rentDateStart, Date rentDateEnd, long rentPrice, char rentStatus, char rentPhase,
			String rentLetterPath, long rentEvidancePath, String rentRejectReason, char updatedBy, Date updatedDate) {
		super();
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

	public char getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(char rentStatus) {
		this.rentStatus = rentStatus;
	}

	public char getRentPhase() {
		return rentPhase;
	}

	public void setRentPhase(char rentPhase) {
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
    
    
	
}

	
