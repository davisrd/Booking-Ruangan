package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EXTERNAL USER")
public class ExternalUser {
 
    @Id
    @GeneratedValue
    @Column(name="ORGANIZATION TYPE")
    private String OrgType;
     
     
    public ExternalUser(String OrgType){
        this.OrgType = OrgType;
        
    }

	public String getOrgType() {
		return OrgType;
	}

	public void setOrgType(String OrgType) {
		this.OrgType = OrgType;
	}

	
 
    // Getter and Setter methods
}