package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="RESERVATION_LOG")
public class ReservationLog {
    
	@Id
	@Column(name = "RESERVATION_ID", nullable = false)
	@Size (max =10)
	private int reservationId;
	
    @Column(name="RESERVATION_DATE_START")
	private Date rentDateStart;
    
    @Column(name="RESERVATION_DATE_END")
	private Date rentDateEnd;
    
    @Column(name="RESERVATION_STATUS")
	private boolean rentStatus;
    
    @Column(name="RESERVATION_OPERATIONAL_PRICE")
	private long rentOperationalPrice;
    
    @Column(name="RESERVATION_FOLDER_PATH")
	private String rentFolderPath;
    
    @Column(name="RESERVATION_REJECT_REASON")
	private String rentRejectReason;
    
    @Column(name="UPDATED_BY")
	private String updatedBy;
    
    @Column(name="UPDATED_DATE")
	private Date updatedDate;

	public ReservationLog(Date rentDateStart, Date rentDateEnd, boolean rentStatus, long rentOperationalPrice,
			String rentFolderPath, String rentRejectReason, String updatedBy, Date updatedDate) {
		super();
		this.rentDateStart = rentDateStart;
		this.rentDateEnd = rentDateEnd;
		this.rentStatus = rentStatus;
		this.rentOperationalPrice = rentOperationalPrice;
		this.rentFolderPath = rentFolderPath;
		this.rentRejectReason = rentRejectReason;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	
	

	public int getReservationId() {
		return reservationId;
	}



	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
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

	public boolean isRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(boolean rentStatus) {
		this.rentStatus = rentStatus;
	}

	public long getRentOperationalPrice() {
		return rentOperationalPrice;
	}

	public void setRentOperationalPrice(long rentOperationalPrice) {
		this.rentOperationalPrice = rentOperationalPrice;
	}

	public String getRentFolderPath() {
		return rentFolderPath;
	}

	public void setRentFolderPath(String rentFolderPath) {
		this.rentFolderPath = rentFolderPath;
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
