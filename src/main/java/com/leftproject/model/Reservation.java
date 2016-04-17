package com.leftproject.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name="RESERVATION_ID")
	private String reservationId;
    
    @Column(name="RESERVATION_DATE_START")
	private Date reservationDateStart;

    @Column(name="RESERVATION_DATE_END")
	private Date reservationDateEnd;

    @Column(name="RESERVATION_STATUS")
	private boolean reservationStatus;
    
    @Column(name="RESERVATION_FILE_PATH")
	private String reservationFilePath;

    @Column(name="RESERVATION_OPERATIONAL_PRICE")
	private long reservationOperationalPrice;
    
    @Column(name="RESERVATION_REJECT_REASON")
	private String reservationRejectReason;
    
    @Column(name="EVENT_TYPE")
	private String eventType;
    
    @Column(name="EVENT_NAME")
	private String eventName;
    
    @Column(name="EVENT_SCALE")
	private String eventScale;
    
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
	
	private Set<ReservationDisposition> reservationDispositionList;
	private Set<ReservationLog> reservationLogList;
	private Set<ReservationMemorandum> reservationMemorandumList;
}
