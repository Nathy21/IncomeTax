package com.spring.app.employment.datamodel;

public class IncomeTaxRequest {
	
	private String stateName;
	private String filingStatus;
	private String annualSalary;
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getFilingStatus() {
		return filingStatus;
	}
	public void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}
	public String getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(String annualSalary) {
		this.annualSalary = annualSalary;
	}
	

}
