package com.leftproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.google.gson.Gson;

@Entity
@Table(name="USER")
public class User {
 
    @Id
    @Column (name = "USER_CODE")
   	@Size (min = 9 , max = 9)
   	private String userCode;
     
    @Column(name="USER_NAME")
    @Size(max=50)
    private String userName;
     
    @Column(name="USER_PASSWORD")
    @Size(max=50)
    private String userPassword;
     
    @Column(name="USER_TYPE")
    @Size(min = 1, max=1)
    private String userType;
     
    public User(){}

    public User(String userJSON){
    	Gson gson = new Gson();
    	User user = gson.fromJson(userJSON, User.class);
		this.userCode = user.userCode;
		this.userName = user.userName;
		this.userPassword = user.userPassword;
		this.userType = user.userType;
    }
    
	public User(String userCode, String userName, String userPassword, String userType) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
    
   
	
	}

	
	
 
    // Getter and Setter methods
