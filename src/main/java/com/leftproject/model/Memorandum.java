package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="MEMORANDUM")
@Inheritance(strategy=InheritanceType.JOINED)
public class Memorandum {
    @Column(name="MEMORANDUM_ID")
	private String memorandumId;
    
    @Column(name="MEMORANDUM_RECEIVER")
	private String memorandumReceiver;
    
    @Column(name="MEMORANDUM_SUBJECT")
	private String memorandumSubject;
    
    @Column(name="MEMORANDUM_MESSAGE")
	private String memorandumMessage;
    
    @Column(name="MEMORANDUM_STATUS")
	private boolean memorandumStatus;
    
    @Column(name="CREATED_BY")
	private String createdBy;
    
    @Column(name="CREATED_DATE")
	private Date createdDate;

    
	public String getMemorandumId() {
		return memorandumId;
	}

	public void setMemorandumId(String memorandumId) {
		this.memorandumId = memorandumId;
	}

	public String getMemorandumReceiver() {
		return memorandumReceiver;
	}

	public void setMemorandumReceiver(String memorandumReceiver) {
		this.memorandumReceiver = memorandumReceiver;
	}

	public String getMemorandumSubject() {
		return memorandumSubject;
	}

	public void setMemorandumSubject(String memorandumSubject) {
		this.memorandumSubject = memorandumSubject;
	}

	public String getMemorandumMessage() {
		return memorandumMessage;
	}

	public void setMemorandumMessage(String memorandumMessage) {
		this.memorandumMessage = memorandumMessage;
	}

	public boolean isMemorandumStatus() {
		return memorandumStatus;
	}

	public void setMemorandumStatus(boolean memorandumStatus) {
		this.memorandumStatus = memorandumStatus;
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
