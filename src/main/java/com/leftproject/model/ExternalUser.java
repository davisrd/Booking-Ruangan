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
    @Column(name="USER_CODE")
    @Size(min = 9 , max = 9)
    private String userCode;
    
    @Column (name="ORGANIZATION_TYPE")
    @Size(max = 50)
    private String OrgType;
    
    @Column (name="ORGANIZATION_CATEGORY")
    private char OrgCategory;

	public ExternalUser(String userCode, String orgType, char orgCategory) {
		super();
		this.userCode = userCode;
		OrgType = orgType;
		OrgCategory = orgCategory;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getOrgType() {
		return OrgType;
	}

	public void setOrgType(String orgType) {
		OrgType = orgType;
	}

	public char getOrgCategory() {
		return OrgCategory;
	}

	public void setOrgCategory(char orgCategory) {
		OrgCategory = orgCategory;
	}
    
    
     
   
}