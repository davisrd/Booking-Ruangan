package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Table(name="DISPOSITION")
@Inheritance(strategy=InheritanceType.JOINED)
public class Disposition {
    
	@Id
    @GeneratedValue
    @Column(name="DISPOSITION_ID")
	private String dispositionId;

    @Column(name="DISPOSITION_RECEIVER")
	private String dispositionReceiver;

    @Column(name="DISPOSITION_SUBJECT")
	private String dispositionSubject;

    @Column(name="DISPOSITION_MESSAGE")
	private String dispositionMessage;

    @Column(name="DISPOSITION_STATUS")
	private boolean dispositionStatus;

    @Column(name="CREATED_BY")
	private String createdBy;

    @Column(name="CREATED_DATE")
	private Date createdDate;

    public Disposition (String dispositionId, String dispositionSubject, String dispositionMessage, boolean dispositionStatus){
    	this.dispositionId = dispositionId;
    	this.dispositionSubject = dispositionSubject;
    	this.dispositionMessage = dispositionMessage;
    	this.dispositionStatus = dispositionStatus;
    }
    
	public String getDispositionId() {
		return dispositionId;
	}

	public void setDispositionId(String dispositionId) {
		this.dispositionId = dispositionId;
	}

	public String getDispositionReceiver() {
		return dispositionReceiver;
	}

	public void setDispositionReceiver(String dispositionReceiver) {
		this.dispositionReceiver = dispositionReceiver;
	}

	public String getDispositionSubject() {
		return dispositionSubject;
	}

	public void setDispositionSubject(String dispositionSubject) {
		this.dispositionSubject = dispositionSubject;
	}

	public String getDispositionMessage() {
		return dispositionMessage;
	}

	public void setDispositionMessage(String dispositionMessage) {
		this.dispositionMessage = dispositionMessage;
	}

	public boolean isDispositionStatus() {
		return dispositionStatus;
	}

	public void setDispositionStatus(boolean dispositionStatus) {
		this.dispositionStatus = dispositionStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
    
    
}
