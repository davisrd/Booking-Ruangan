package com.leftproject.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RENT")
public class Rent {
    @Id
    @GeneratedValue
    @Column(name="RENT_ID")
	private String rentId;

    @Column(name="ORGANIZATIONAL_NAME")
	private String organizationName;

    @Column(name="RENT_DATE_START")
	private Date rentDateStart;

    @Column(name="RENT_DATE_END")
	private Date rentDateEnd;

    @Column(name="RENT_PRICE")
	private long rentPrice;

    @Column(name="RENT_OPERATIONAL_PRICE")
	private long rentOperationalPrice;

    @Column(name="RENT_STATUS")
	private boolean rentStatus;

    @Column(name="RENT_FILE_PATH")
	private String rentFilePath;

    @Column(name="EVENT_CATEGORY")
	private String eventCategory;

    @Column(name="EVENT_NAME")
	private String eventName;

    @Column(name="EVENT_TOTAL_PARTICIPANT")
	private int eventTotalParticipant;

    @Column(name="CREATED_DATE")
	private Date createdDate;

    @Column(name="UPDATED_BY")
	private String updatedBy;

    @Column(name="UPDATED_DATE")
	private Date updatedDate;

	private User user;
	
	private Facility facility;
	
//	@OneToMany(mappedBy="department")
//    @JoinColumn(name="department_id")
//    @IndexColumn(name="idx")
    private Set<RentDisposition> rentDispositionList;
	private Set<RentLog> rentLogList;
	private Set<RentMemorandum> rentMemorandumList;
	
	
}
