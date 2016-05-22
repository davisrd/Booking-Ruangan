package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="EXTERNAL USER")
public class ExternalUser{
 
    @Id
    @Column(name="ORGANIZATION_TYPE")
    @Size(max = 50)
    private String OrgType;
    
    @Column (name="ORGANIZATION_CATEGORY")
    @Size(max = 1)
    private char OrgCat;
     
    public ExternalUser(String OrgType){
        this.OrgType = OrgType;  
    
    }

	public char getOrgCat() {
		return OrgCat;
	}

	public void setOrgCat(char orgCat) {
		OrgCat = orgCat;
	}



	public String getOrgType() {
		return OrgType;
	}

	public void setOrgType(String OrgType) {
		this.OrgType = OrgType;
	}

	
 
    // Getter and Setter methods
}