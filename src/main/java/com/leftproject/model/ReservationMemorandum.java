package com.leftproject.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION_MEMORANDUM")
@PrimaryKeyJoinColumn(name="MEMORANDUM_ID")
public class ReservationMemorandum extends Memorandum {

}
