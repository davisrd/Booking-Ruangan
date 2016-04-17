package com.leftproject.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RENT_LOG")
public class RentLog {
    
    @Column(name="RENT_DATE_START")
	private Date rentDateStart;
    
    @Column(name="RENT_DATE_END")
	private Date rentDateEnd;
    
    @Column(name="RENT_PRICE")
	private long rentPrice;
    
    @Column(name="RENT_STATUS")
	private boolean rentStatus;
    
    @Column(name="RENT_OPERATIONAL_PRICE")
	private long rentOperationalPrice;
    
    @Column(name="RENT_FOLDER_PATH")
	private String rentFolderPath;
    
    @Column(name="RENT_REJECT_REASON")
	private String rentRejectReason;
    
    @Column(name="UPDATED_BY")
	private String updatedBy;
    
    @Column(name="UPDATED_DATE")
	private Date updatedDate;

}
