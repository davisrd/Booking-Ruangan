package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CANCELED_RESERVATION")
public class CanceledReservation {
    @Column(name="CANCELED_RESERVATION_REASON")
	private String canceledReservationReason;

	public String getCanceledReservationReason() {
		return canceledReservationReason;
	}

	public void setCanceledReservationReason(String canceledReservationReason) {
		this.canceledReservationReason = canceledReservationReason;
	}
    
    
}
