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
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="RENT")
public class Rent {
    @Id
    @Column(name="RENT_ID")
	private int rentId;
    
    @Column(name="RENT_CODE")
    @Size(min=9 ,max=9)
    private char rentCode;

    @Column(name="RENTER")
	private String renter;

    @Column(name="RENT_DATE_START")
	private Date rentDateStart;

    @Column(name="RENT_DATE_END")
	private Date rentDateEnd;

    @Column(name="RENT_PRICE")
	private long rentPrice;

    @Column(name="RENT_OPERATIONAL_PRICE")
	private long rentOperationalPrice;

    @Column(name="RENT_STATUS")
    @Size(min=1,max=1)
	private boolean rentStatus;
    
    @Column(name="RENT_PHASE")
    @Size(min=1,max=1)
	private boolean rentPhase;
    
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

    @Column(name="EVENT_CATEGORY")
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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;
	
//	@OneToMany(mappedBy="department")
//    @JoinColumn(name="department_id")
//    @IndexColumn(name="idx")
	
	
}
