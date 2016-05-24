package com.leftproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

public class OtherEmployee {
	@Entity
	@Table(name="OTHER EMPLOYEE")
	public class ExternalUser{
		
		@Id
		@Column (name = "USER_CODE")
		@Size (min = 9 , max = 9)
		private String userCode;
		
		@Column (name = "EMPLOYEE_POSTION")
		@Size (max = 50)
		private String employeePosition;
		
		@Column (name = "EMPOYEE_UNIT")
		@Size (max = 50)
		private String employeeUnit;

		public ExternalUser(String userCode, String employeePosition, String employeeUnit) {
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
	 
	
	

}
