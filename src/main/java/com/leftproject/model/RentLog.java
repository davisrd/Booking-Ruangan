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
@Table(name="RENT_LOG")
public class RentLog {
	@Id
	@Column(name = "RENT_ID", nullable = false)
	private int rentId;
	
    @Column(name="RENT_DATE_START")
	private Date rentDateStart;
    
    @Column(name="RENT_DATE_END")
	private Date rentDateEnd;
    
    @Column(name="RENT_PRICE")
	private long rentPrice;
    
    @Column(name="RENT_STATUS")
    @Size(min=2,max=2)
	private String rentStatus;
    
    @Column(name="RENT_OPERATIONAL_PRICE")
	private long rentOperationalPrice;
    
    @Column(name="RENT_FOLDER_PATH")
    @Size(max = 100)
	private String rentFolderPath;
    
    @Column(name="RENT_REJECT_REASON")
	private String rentRejectReason;
    
    @Column(name="UPDATED_BY")
    @Size(min=50,max=50)
	private String updatedBy;
    
    @Column(name="UPDATED_DATE")
	private Date updatedDate;
    
    public RentLog(Date rentDateStart, Date rentDateEnd, long rentPrice, String rentStatus, long rentOperationalPrice,
			String rentFolderPath, String rentRejectReason, String updatedBy, Date updatedDate) {
		super();
		this.rentDateStart = rentDateStart;
		this.rentDateEnd = rentDateEnd;
		this.rentPrice = rentPrice;
		this.rentStatus = rentStatus;
		this.rentOperationalPrice = rentOperationalPrice;
		this.rentFolderPath = rentFolderPath;
		this.rentRejectReason = rentRejectReason;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

    
    
	public int getRentId() {
		return rentId;
	}



	public void setRentId(int rentId) {
		this.rentId = rentId;
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

	public String isRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
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

	
