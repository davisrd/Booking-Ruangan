package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
 
    @Id
    @Column(name="STUDENT_FACULTY")
    private String StudentFac;
     
    @Column(name="STUDENT_MAJOR")
    private String StudentMaj;
     
  
    
  
     
    public Student(String StudentFac, String StudentMaj){
        this.StudentFac = StudentFac;
        this.StudentMaj = StudentMaj;
        
    }

	public String getStudentFac() {
		return StudentFac;
	}

	public void setStudentFac(String StudentFac) {
		this.StudentFac = StudentFac;
	}

	public String getStudentMaj() {
		return StudentMaj;
	}

	public void setStudentMaj(String StudentMaj ) {
		this.StudentMaj = StudentMaj;
	}

	
 
    // Getter and Setter methods
}