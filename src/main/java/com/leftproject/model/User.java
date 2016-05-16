package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
 
    @Id
    @Column(name="USER_ID")
    private String userId;
     
    @Column(name="USER_NAME")
    private String userName;
     
    @Column(name="USER_PASSWORD")
    private String userPassword;
     
    @Column(name="USER_TYPE")
    private int userType;
     
    public User(){}
    
    public User(String userId, String userName,String userPassword, int userType){
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
       
    }

	public String getuserId() {
		return userId;
	}

	public void userId(String userId) {
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

	public void setuserType(int userType) {
		this.userType = userType;
	}

	
	
 
    // Getter and Setter methods
}