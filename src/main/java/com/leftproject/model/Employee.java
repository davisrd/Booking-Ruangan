package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
 
    @Id
    @Column(name="employee_position")
    @Size (max = 50)
    private String employeePosition;
     
    @Column(name="employee_Department")
    @Size (max = 50)
    private String employeeDepartment;
     
  
    
  
     
    public Employee(String employeePosition, String employeeDepartment){
        this.employeePosition = employeePosition;
        this.employeeDepartment = employeeDepartment;
        
    }

	public String getemployeePosition() {
		return employeePosition;
	}

	public void setemployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

	public String getemployeeDepartment() {
		return employeeDepartment;
	}

	public void setemployeeDepartment(String employeeDepartment ) {
		this.employeeDepartment = employeeDepartment;
	}

	
 
    // Getter and Setter methods
}