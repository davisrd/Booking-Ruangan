package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MANAGEMENT")
public class Management {
 
    @Id
    @GeneratedValue
    @Column(name="management_position")
    private String managementPosition;
     
    @Column(name="management_Department")
    private String managementDepartment;
     
  
    
  
     
    public Management(String managementPosition, String managementDepartment){
        this.managementPosition = managementPosition;
        this.managementDepartment = managementDepartment;
        
    }

	public String getmanagementPosition() {
		return managementPosition;
	}

	public void setmanagementPosition(String managementPosition) {
		this.managementPosition = managementPosition;
	}

	public String getmanagementDepartment() {
		return managementDepartment;
	}

	public void setmanagementDepartment(String managementDepartment ) {
		this.managementDepartment = managementDepartment;
	}

	
 
    // Getter and Setter methods
}