package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="MEMORANDUM")
@Inheritance(strategy=InheritanceType.JOINED)
public class Memorandum {
	@Id
    @Column(name="MEMORANDUM_ID", nullable = false)
	@Size(min=10, max=10)
	private int memorandumId;
    
	@Column (name="MEMORANDUM_CODE")
	@Size (min=7, max=7)
	private String memorandumCode;
	
	
    @Column(name="MEMORANDUM_RECEIVER")
    @Size(min=8, max=8)
	private String memorandumReceiver;
    
    @Column(name="MEMORANDUM_SUBJECT")
    @Size(max=50)
	private String memorandumSubject;
    
    @Column(name="MEMORANDUM_MESSAGE")
	private String memorandumMessage;
    
    @Column(name="MEMORANDUM_STATUS")
	private boolean memorandumStatus;
    
    @Column(name="CREATED_BY")
    @Size(max=50)
	private String createdBy;
    
    @Column(name="CREATED_DATE")
	private Date createdDate;

    
    
    
	public Memorandum(int memorandumId, String memorandumCode, String memorandumReceiver, String memorandumSubject,
			String memorandumMessage, boolean memorandumStatus, String createdBy, Date createdDate) {
		super();
		this.memorandumId = memorandumId;
		this.memorandumCode = memorandumCode;
		this.memorandumReceiver = memorandumReceiver;
		this.memorandumSubject = memorandumSubject;
		this.memorandumMessage = memorandumMessage;
		this.memorandumStatus = memorandumStatus;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public String getMemorandumCode() {
		return memorandumCode;
	}

	public void setMemorandumCode(String memorandumCode) {
		this.memorandumCode = memorandumCode;
	}

	public int getMemorandumId() {
		return memorandumId;
	}
	
	public void setMemorandumId(int memorandumId) {
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
