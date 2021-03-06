package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
 
    @Id
    @Column(name="USER_CODE")
    @Size (max = 8 ,min = 8)
    private String userCode;
     
    @Column(name="EMPLOYEE_POSITION")
    @Size (max = 50)
    private String employeePosition;
    
    @Column (name= "EMPLOYEE_UNIT")
    @Size (max =50)
    private String employeeUnit;
    
    public Employee()
    {
    	
    }

	public Employee(String userCode, String employeePosition, String employeeUnit) {
		super();
		this.userCode = userCode;
		this.employeePosition = employeePosition;
		this.employeeUnit = employeeUnit;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

	public String getEmployeeUnit() {
		return employeeUnit;
	}

	public void setEmployeeUnit(String employeeUnit) {
		this.employeeUnit = employeeUnit;
	}

	
  
    // Getter and Setter methods
}