package com.leftproject.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROOM")
public class RoomManager {
 
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private String userId;
    
    @OneToMany(mappedBy="ROOM")
    private Set<Room> room;
    
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