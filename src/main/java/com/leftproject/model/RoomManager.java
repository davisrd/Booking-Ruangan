package com.leftproject.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROOM_MANAGER")
public class RoomManager {
 
    @Id
    @Column(name="user_id")
    private char userId;
    
   
    
    public RoomManager(char userId){
        this.userId = userId;
    }
        
        public char getuserId() {
    		return userId;
    	}

    	public void setuserId(char userId) {
    		this.userId = userId;
    	}
    	
    }