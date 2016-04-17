package com.leftproject.model;

import java.util.Date;
import java.util.Set;

public class Rent {
	private String rentId;
	private Date rentDateStart;
	private Date rentDateEnd;
	private long rentPrice;
	private long rentOperationalPrice;
	private boolean rentStatus;
	private String rentFilePath;
	private String eventCategory;
	private String eventName;
	private int eventTotalParticipant;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;

	private User user;
	
//	@OneToMany(mappedBy="department")
//    @JoinColumn(name="department_id")
//    @IndexColumn(name="idx")
    private Set<RentDisposition> rentDispositionList;
	private Set<RentLog> rentLogList;
	private Set<RentMemorandum> rentMemorandumList;
}
