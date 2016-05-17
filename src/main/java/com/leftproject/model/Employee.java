package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
 
    @Id
    @Column(name="employee_position")
    private String employeePosition;
     
    @Column(name="employee_Department")
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