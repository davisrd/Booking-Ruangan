package com.leftproject.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="RENT_DISPOSITION")
@PrimaryKeyJoinColumn(name="DISPOSITION_ID")
public class RentDisposition extends Disposition {

	public RentDisposition(String dispositionId, String dispositionSubject, String dispositionMessage,
			boolean dispositionStatus, String createdBy, Date createdDate) {
		super(dispositionId, dispositionSubject, dispositionMessage, dispositionStatus, createdBy, createdDate);
		// TODO Auto-generated constructor stub
	}

	

}
