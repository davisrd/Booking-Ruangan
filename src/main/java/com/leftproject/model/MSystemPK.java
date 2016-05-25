package com.leftproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class MSystemPK implements Serializable {

	@Id
    @Column(name="CATEGORY")
	@Size(max = 50)
    private String category;
	
	@Id
	@Column(name="SUB_CATEGORY")
	private Character subCategory;
	
	public MSystemPK() {}

    public MSystemPK(String category, Character subCategory) {
        this.category = category;
        this.subCategory = subCategory;
    }
}
