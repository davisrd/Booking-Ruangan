package com.websystique.springmvc.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Controller;

import com.google.gson.Gson;


@Entity
@Table(name="facility")
@Controller("/facility")
public class Facility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="facility_id", nullable=false)
	private int id;
	
	@NotNull
	@Size(max=50)
	@Column(name="facility_name", nullable=false)
	private String facilityName;
	
	@NotNull
	@Column(name="facility_type", nullable=false)
	private int facilityType;
	
	@NotNull
	@Column(name="facility_status", nullable=false)
	private int facilityStatus;
	
	@Column(name="facility_price")
	private long facilityPrice;
	
	
	
	public Facility()
	{
		
	}
	
	public Facility(String facilityJSON)
	{
		Gson gson = new Gson();
	    Facility facility = gson.fromJson(facilityJSON, Facility.class);
	    this.id = facility.getId();
	    this.facilityName = facility.getFacilityName();
	    this.facilityType = facility.getFacilityType();
	    this.facilityStatus = facility.getFacilityStatus();
	    this.facilityPrice = facility.getFacilityPrice();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public int getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(int facilityType) {
		this.facilityType = facilityType;
	}
	public int getFacilityStatus() {
		return facilityStatus;
	}
	public void setFacilityStatus(int facilityStatus) {
		this.facilityStatus = facilityStatus;
	}
	public long getFacilityPrice() {
		return facilityPrice;
	}
	public void setFacilityPrice(long facilityPrice) {
		this.facilityPrice = facilityPrice;
	}

	
	
}
