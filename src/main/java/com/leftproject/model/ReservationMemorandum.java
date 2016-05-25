package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="RESERVATION_MEMORANDUM")
@PrimaryKeyJoinColumn(name="MEMORANDUM_ID")
public class ReservationMemorandum  {

	
	    @Id
	    @Column(name="MEMORANDUM_ID")
		private int memorandumId;
	    
	    @Column(name="MEMORANDUM_RECEIVER")
	    @Size (min =1 , max =1)
		private String memorandumReceiver;
	    
	    @Column(name="MEMORANDUM_SUBJECT")
		private String memoradumSubject;
	    
	    @Column(name="MEMORANDUM_MESSAGE")
	   	private String memorandumMessage;
	    
	    @Column(name="MEMORANDUM_STATUS")
		private boolean memorandumStatus;
	    
	    @Column(name="CRATED_BY")
	    @Size (max = 50)
		private String memCreatedBy;
	    
	    @Column(name="CREATED_DATE")
	    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
		private Date memCreatedDate;
	    
	    public ReservationMemorandum()
	    {
	    	
	    }

		public ReservationMemorandum(int memorandumId, String memorandumReceiver, String memoradumSubject,
				String memorandumMessage, boolean memorandumStatus, String memCreatedBy, Date memCreatedDate) {
			super();
			this.memorandumId = memorandumId;
			this.memorandumReceiver = memorandumReceiver;
			this.memoradumSubject = memoradumSubject;
			this.memorandumMessage = memorandumMessage;
			this.memorandumStatus = memorandumStatus;
			this.memCreatedBy = memCreatedBy;
			this.memCreatedDate = memCreatedDate;
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

		public String getMemoradumSubject() {
			return memoradumSubject;
		}

		public void setMemoradumSubject(String memoradumSubject) {
			this.memoradumSubject = memoradumSubject;
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

		public String getMemCreatedBy() {
			return memCreatedBy;
		}

		public void setMemCreatedBy(String memCreatedBy) {
			this.memCreatedBy = memCreatedBy;
		}

		public Date getMemCreatedDate() {
			return memCreatedDate;
		}

		public void setMemCreatedDate(Date memCreatedDate) {
			this.memCreatedDate = memCreatedDate;
		}
	    
	    
	    
}
