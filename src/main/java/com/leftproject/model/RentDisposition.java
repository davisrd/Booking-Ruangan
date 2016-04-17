package com.leftproject.model;

import javax.persistence.*;

@Entity
@Table(name="RENT_DISPOSITION")
@PrimaryKeyJoinColumn(name="DISPOSITION_ID")
public class RentDisposition extends Disposition {

}
