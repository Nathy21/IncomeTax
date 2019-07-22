package com.spring.app.employment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.employment.datamodel.FederalMarriedTogether;
import com.spring.app.employment.datamodel.FederalSingle;
import com.spring.app.employment.datamodel.IncomeTaxRequest;
import com.spring.app.employment.datamodel.States;
import com.spring.app.employment.repository.StatesRepository;

@Service
public class StatesService {
	
	@Autowired
	StatesRepository repository;
	
	public List<States> getAllStateInfo() {
		List<States> states = new ArrayList<>();
		repository.findAll().forEach(state -> states.add(state));		
		return states;
	}
	
	public void deleteStateDetails(int id) {
		repository.deleteById(id);
	}
	
	public void saveOrUpdate(States state) {
		repository.save(state);
	}
	
	public States getStateById(int id) {
		return repository.findById(id).get();
	}

	public double calculateIncomeTax(IncomeTaxRequest taxRequest, List<States> allStateInfo,
			List<FederalSingle> allFederalSingleTax, List<FederalMarriedTogether> allFederalMarriedTogetherTax) {
		States state = getStateDetails(allStateInfo, taxRequest.getStateName());
		double federalTaxPerdentage = 0.00;
		
		if("Single".equalsIgnoreCase(taxRequest.getFilingStatus())) {
			federalTaxPerdentage = getFederalSingleTaxPercent(taxRequest.getAnnualSalary(), allFederalSingleTax);
		} else if("Married Filing Jointly".equalsIgnoreCase(taxRequest.getFilingStatus())) {
			federalTaxPerdentage = getFederalMarriedTogetherTaxPercent(taxRequest.getAnnualSalary(), allFederalMarriedTogetherTax);
		}
		return calculateTaxValue(Double.parseDouble(taxRequest.getAnnualSalary()), federalTaxPerdentage, Double.parseDouble(state.getTaxMax()));
	}
	
	private double calculateTaxValue(double annualSalary, double federalPercent, double statePercent) {
		double totalIncomeTax = 0.00;		
		double federalTotal = (annualSalary * federalPercent) / 100;
		double stateTotal = (annualSalary * statePercent) / 100;
		totalIncomeTax = federalTotal + stateTotal;
		return totalIncomeTax;
	}

	private States getStateDetails(List<States> allStateInfo, String stateName) {
		States state = null;
		for (States stateObj : allStateInfo) {
			if(stateName.equalsIgnoreCase(stateObj.getStateName())) {
				state = stateObj;
				break;
			}
		}		
		return state;
	}
	
	private int getFederalSingleTaxPercent(String annualSalary, List<FederalSingle> allFederalSingleTax) {
		int federalTaxPercent = 0;
		if(annualSalary != null) {	
			int annualSalaryVal = Integer.valueOf(annualSalary);
			for(FederalSingle federalSingle: allFederalSingleTax) {				
				if(annualSalaryVal > Integer.valueOf(federalSingle.getMinPay()) && 
						(annualSalaryVal < Integer.valueOf(federalSingle.getMaxPay()) || 
								Integer.valueOf(federalSingle.getMaxPay()) == 1000000)) {
					federalTaxPercent = Integer.valueOf(federalSingle.getTaxRate());
					break;
				}
			}
		}
		return federalTaxPercent;
	}
	
	private int getFederalMarriedTogetherTaxPercent(String annualSalary, List<FederalMarriedTogether> allFederalMarriedTogetherTax) {
		int federalTaxPercent = 0;
		if(annualSalary != null) {	
			int annualSalaryVal = Integer.valueOf(annualSalary);
			for(FederalMarriedTogether federalMarriedTogether: allFederalMarriedTogetherTax) {				
				if(annualSalaryVal > Integer.valueOf(federalMarriedTogether.getMinPay()) && 
						(annualSalaryVal < Integer.valueOf(federalMarriedTogether.getMaxPay()) || 
								Integer.valueOf(federalMarriedTogether.getMaxPay()) == 1000000)) {
					federalTaxPercent = Integer.valueOf(federalMarriedTogether.getTaxRate());
					break;
				}
			}
		}
		return federalTaxPercent;
	}

}
