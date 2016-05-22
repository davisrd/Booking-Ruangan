package com.leftproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION_MEMORANDUM")
@PrimaryKeyJoinColumn(name="MEMORANDUM_ID")
public class ReservationMemorandum extends Memorandum {

	public ReservationMemorandum(int memorandumId, String memorandumCode, String memorandumReceiver,
			String memorandumSubject, String memorandumMessage, boolean memorandumStatus, String createdBy,
			Date createdDate) {
		super(memorandumId, memorandumCode, memorandumReceiver, memorandumSubject, memorandumMessage, memorandumStatus,
				createdBy, createdDate);
		// TODO Auto-generated constructor stub
	}

}
