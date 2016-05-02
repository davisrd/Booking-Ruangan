package com.leftproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROOM")
public class RoomManager {
 
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private String userId;
    
   
    
    public RoomManager(String userId){
        this.userId = userId;
    }
        
        public String getuserId() {
    		return userId;
    	}

    	public void setuserId(String userId) {
    		this.userId = userId;
    	}
    	
    }