package com.leftproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.google.gson.Gson;

@Entity
@Table(name="ROOM_MANAGER")
public class RoomManager {
 
    @Id
    @Column(name="USER_CODE")
    @Size (min = 9 , max = 9)
    private String userCode;
    
   @Column(name="EMPLOYEE_POSITION")
   @Size (max = 50)
   private String employeePosition;
   
   @Column (name= "EMPLOYEE_UNIT")
   @Size (max =50)
   private String employeeUnit;
      
   
   
    public RoomManager() {
		super();
		// TODO Auto-generated constructor stub
	}

    public RoomManager(String roomManagerJSON) {
		super();
       	Gson gson = new Gson();
       	RoomManager roomManager = gson.fromJson(roomManagerJSON, RoomManager.class);
		this.userCode = roomManager.userCode;
		this.employeePosition = roomManager.employeePosition;
		this.employeeUnit = roomManager.employeeUnit;
		// TODO Auto-generated constructor stub
	}
    
	public RoomManager(String userCode, String employeePosition, String employeeUnit) {
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
    	
    	
}