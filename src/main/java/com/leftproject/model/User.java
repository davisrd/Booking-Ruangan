package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="USER")
public class User {
 
    @Id
    @Column(name="USER_ID")
    @Size(max=8)
    private String userId;
     
    @Column(name="USER_NAME")
    @Size(max=50)
    private String userName;
     
    @Column(name="USER_PASSWORD")
    @Size(max=50)
    private String userPassword;
     
    @Column(name="USER_TYPE")
    @Size(max=2)
    private char userType;
     
    public User(){}
    
    public User(String userId, String userName,String userPassword, char userType){
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
       
    }

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
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