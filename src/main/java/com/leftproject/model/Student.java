package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="STUDENT")
public class Student {
 
    @Id
    @Column (name = "USER_CODE")
   	@Size (min = 9 , max = 9)
   	private String userCode;
    
    @Column(name="STUDENT_FACULTY")
    @Size(max=50)
    private String StudentFac;
     
    @Column(name="STUDENT_MAJOR")
    @Size(max=50)
    private String StudentMaj;

	public Student(String userCode, String studentFac, String studentMaj) {
		super();
		this.userCode = userCode;
		StudentFac = studentFac;
		StudentMaj = studentMaj;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getStudentFac() {
		return StudentFac;
	}

	public void setStudentFac(String studentFac) {
		StudentFac = studentFac;
	}

	public String getStudentMaj() {
		return StudentMaj;
	}

	public void setStudentMaj(String studentMaj) {
		StudentMaj = studentMaj;
	}
     
  
    
  
     
   
}