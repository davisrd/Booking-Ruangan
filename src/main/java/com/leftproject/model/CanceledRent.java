package com.leftproject.model;

import javax.persistence.*;
import javax.persistence.Column;

@Entity
@Table(name="CANCELED_RENT")
public class CanceledRent {
	@Id
	@Column(name = "ID_RENT", nullable = false)
	private int id;
	
    @Column(name="CANCELED_RENT_REASON")
	private String canceledRentReason;

	public String getCanceledRentReason() {
		return canceledRentReason;
	}

	public void setCanceledRentReason(String canceledRentReason) {
		this.canceledRentReason = canceledRentReason;
	}
}
