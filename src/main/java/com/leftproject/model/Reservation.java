package com.leftproject.model;

import java.util.Date;
import java.util.Set;

public class Reservation {
	private String reservationId;
	private Date reservationDateStart;
	private Date reservationDateEnd;
	private boolean reservationStatus;
	private String reservationFilePath;
	private String eventType;
	private String eventName;
	private String eventScale;
	private int eventTotalParticipant;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;

	private User user;
	private Set<ReservationDisposition> reservationDispositionList;
	private Set<ReservationLog> reservationLogList;
	private Set<ReservationMemorandum> reservationMemorandumList;
}
