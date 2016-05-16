package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CANCELED_RESERVATION")
public class CanceledReservation {
	@Id
	@Column(name = "id_reservatoin", nullable = false)
	private int id;
	
    @Column(name="CANCELED_RESERVATION_REASON")
	private String canceledReservationReason;

	public String getCanceledReservationReason() {
		return canceledReservationReason;
	}

	public void setCanceledReservationReason(String canceledReservationReason) {
		this.canceledReservationReason = canceledReservationReason;
	}
    
    
}
