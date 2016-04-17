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
}
