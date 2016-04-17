package com.leftproject.model;

import javax.persistence.*;

@Entity
@Table(name="CANCELED_RENT")
public class CanceledRent {
	private String canceledRentReason;
}
