package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class System {

	
	@Entity
	@Table(name="SCHEDULE")
	public class Schedule {
		
		@Id
	    @Column(name="CATEGORY")
		@Size(max = 50)
	    private char category;
		
		@Id
		@Column(name="SUB_CATEGORY")
		@Size(max=50)
		private char subCategory;
		
		@Column (name= "DATA_VALUE")
		private char dataValue;
		
		@Column (name = "DESCRIPTION")
		@Size (max = 225)
		private String description;
		
		@Column(name="CREATED_DATE")
		@DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	    private Date createdDate;
		    
		@Column(name="CREATED_BY")
	    private Date createdby;
		    
		@Column(name="UPDATED_BY")
	    @Size (max =50 )
		private char updatedBy;
		
	    @Column(name="UPDATED_DATE")
	    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
		private Date updatedDate;

		public Schedule(char category, char subCategory, char dataValue, String description, Date createdDate,
				Date createdby, char updatedBy, Date updatedDate) {
			super();
			this.category = category;
			this.subCategory = subCategory;
			this.dataValue = dataValue;
			this.description = description;
			this.createdDate = createdDate;
			this.createdby = createdby;
			this.updatedBy = updatedBy;
			this.updatedDate = updatedDate;
		}

		public char getCategory() {
			return category;
		}

		public void setCategory(char category) {
			this.category = category;
		}

		public char getSubCategory() {
			return subCategory;
		}

		public void setSubCategory(char subCategory) {
			this.subCategory = subCategory;
		}

		public char getDataValue() {
			return dataValue;
		}

		public void setDataValue(char dataValue) {
			this.dataValue = dataValue;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public Date getCreatedby() {
			return createdby;
		}

		public void setCreatedby(Date createdby) {
			this.createdby = createdby;
		}

		public char getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(char updatedBy) {
			this.updatedBy = updatedBy;
		}

		public Date getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}

	
	
	
	
	}
	


}
