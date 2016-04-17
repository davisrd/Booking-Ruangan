package com.leftproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FACILITY")
public class Facility {
 
    @Id
    @GeneratedValue
    @Column(name="facility_id")
    private String facilityId;
     
    @Column(name="facility_name")
    private String facilityName;
     
    @Column(name="facility_type")
    private Boolean facilityType;
     
    @Column(name="facility_status")
    private Boolean facilityStatus;
     
    @Column(name="facility_price")
    private long facilityPrice;
    
  
     
    public Facility(String facilityId, String facilityName,boolean facilityType, boolean facilityStatus, long facilityPrice){
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityType = facilityType;
        this.facilityStatus = facilityStatus;
        this.facilityPrice = facilityPrice;
    }

	public String getfacilityId() {
		return facilityId;
	}

	public void setfacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getfacilityName() {
		return facilityName;
	}

	public void setfacilityName(String facilityName ) {
		this.facilityName = facilityName;
	}

	public boolean getfacilityType() {
		return facilityType;
	}

	public void setfacilityType(boolean facilityType ) {
		this.facilityType = facilityType;
	}


	public boolean getfacilityStatus() {
		return facilityStatus;
	}

	public void setfacilityStatus(boolean facilityStatus) {
		this.facilityStatus = facilityStatus;
	}

	public long  getfacilityPrice() {
		return facilityPrice;
	}

	public void setfacilityPrice(Long facilityPrice) {
		this.facilityPrice = facilityPrice;
	}
 
    // Getter and Setter methods
}