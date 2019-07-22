package com.spring.app.employment.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
@NoArgsConstructor

@Table(name = "states")
@Entity
public class States {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String stateName;
	
	private String taxMax;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getTaxMax() {
		return taxMax;
	}

	public void setTaxMax(String taxMax) {
		this.taxMax = taxMax;
	}
	
	
}
