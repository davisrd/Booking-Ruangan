package com.leftproject.model;

import javax.persistence.*;
import javax.persistence.Column;

@Entity
@Table(name="CANCELED_RENT")
public class CanceledRent {
    @Column(name="CANCELED_RENT_REASON")
	private String canceledRentReason;
}
