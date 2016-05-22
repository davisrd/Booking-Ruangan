package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="USER")
public class User {
 
    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private int userId;
    
    @Column(name="USER_CODE")
    @Size(max=8)
    private String userCode;
     
    @Column(name="USER_NAME")
    @Size(max=50)
    private String userName;
     
    @Column(name="USER_PASSWORD")
    @Size(max=50)
    private String userPassword;
     
    @Column(name="USER_TYPE")
    @Size(max=1)
    private char userType;
     
    public User(){}
    
    public User(int userId, String userCode, String userName,String userPassword, char userType){
        this.userId = userId;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public String getuserCode() {
		return userCode;
	}

	public void setuserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName ) {
		this.userName = userName;
	}

	public String getuserPassword() {
		return userPassword;
	}

	public void setuserPassword(String userPassword ) {
		this.userPassword = userPassword;
	}


	public int getuserTypes() {
		return userType;
	}

	public void setuserType(char userType) {
		this.userType = userType;
	}

	
	
 
    // Getter and Setter methods
}