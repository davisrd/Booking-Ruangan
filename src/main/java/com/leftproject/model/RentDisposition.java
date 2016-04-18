package com.leftproject.model;

import javax.persistence.*;

@Entity
@Table(name="RENT_DISPOSITION")
@PrimaryKeyJoinColumn(name="DISPOSITION_ID")
public class RentDisposition extends Disposition {

	public RentDisposition(String dispositionId, String dispositionSubject, String dispositionMessage,
			boolean dispositionStatus) {
		super(dispositionId, dispositionSubject, dispositionMessage, dispositionStatus);
		// TODO Auto-generated constructor stub
	}

}
