package com.leftproject.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION_DISPOSITION")
@PrimaryKeyJoinColumn(name="DISPOSITION_ID")
public class ReservationDisposition extends Disposition {

	public ReservationDisposition(String dispositionId, String dispositionSubject, String dispositionMessage,
			boolean dispositionStatus) {
		super(dispositionId, dispositionSubject, dispositionMessage, dispositionStatus);
		// TODO Auto-generated constructor stub
	}
	
}
