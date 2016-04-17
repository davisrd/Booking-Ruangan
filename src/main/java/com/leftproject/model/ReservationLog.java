package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION_LOG")
public class ReservationLog {
    
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

}
