package com.spring.app.employment.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Table( name = "federal_single" )
@Entity
@NoArgsConstructor
public class FederalSingle {

	@Id
	@GeneratedValue
	private int id;
	
	private String taxRate;
	
	private String minPay;
	
	private String maxPay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getMinPay() {
		return minPay;
	}

	public void setMinPay(String minPay) {
		this.minPay = minPay;
	}

	public String getMaxPay() {
		return maxPay;
	}

	public void setMaxPay(String maxPay) {
		this.maxPay = maxPay;
	}
	
	
}
