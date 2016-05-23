package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="ALUMNUS")
public class Alumnus {
	
	@Id
	@Column (name = "USER_CODE")
	@Size (min = 9 , max = 9)
	private String userCode;

	public Alumnus(String userCode) {
		super();
		this.userCode = userCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	

}
