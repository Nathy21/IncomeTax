package com.spring.app.employment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.employment.datamodel.FederalMarriedTogether;
import com.spring.app.employment.datamodel.FederalSingle;
import com.spring.app.employment.datamodel.IncomeTaxRequest;
import com.spring.app.employment.datamodel.States;
import com.spring.app.employment.service.FederalMarriedTogetherService;
import com.spring.app.employment.service.FederalSingleService;
import com.spring.app.employment.service.StatesService;

@CrossOrigin(origins = "*")
@RestController
public class TaxCalculatorController {
	
	  private final StatesService statesService;
	  private final FederalSingleService federalSingleService;
	  private final FederalMarriedTogetherService federalMarriedTogetherService;
	  
	  public TaxCalculatorController(StatesService statesService, FederalSingleService federalSingleService,
			  FederalMarriedTogetherService federalMarriedTogetherService) {
		  this.statesService = statesService;
		  this.federalSingleService = federalSingleService;
		  this.federalMarriedTogetherService = federalMarriedTogetherService;		  
	  }

	  
	  @GetMapping("/states")
	  @ResponseStatus(HttpStatus.OK)
	  public List<States> getAllStates() {
		  return statesService.getAllStateInfo();
	  }
	  
	  @DeleteMapping("/state/{id}")
	  @ResponseStatus(HttpStatus.OK)
	  public void deleteStateDetails(@PathVariable("id") int id) {
		  statesService.deleteStateDetails(id);
	  }
	  
	  @PostMapping("/state/create")
	  @ResponseStatus(HttpStatus.CREATED)
	  public int addStateDetail(@RequestBody States state) {
		  
		  if(state != null) {
			  statesService.saveOrUpdate(state);
		  }
		  return state.getId();
	  }
	  
	  @PutMapping("/state/update")
	  @ResponseStatus(HttpStatus.ACCEPTED)
	  public int updateStateDetails(@RequestBody States state) {
		  
		  if(state != null) {
			  statesService.saveOrUpdate(state);
		  }
		  return state.getId();
	  }
	  
	  @GetMapping("/FederalSingleFilingRange")
	  @ResponseStatus(HttpStatus.OK)
	  public List<FederalSingle> getAllFederalSingleFilingRanges() {
		  return federalSingleService.getAllFederalSingleTax();
	  }
	  
	  @GetMapping("/FederalMarriedTogetherFilingRange")
	  @ResponseStatus(HttpStatus.OK)
	  public List<FederalMarriedTogether> getAllFederalMarriedTogetherFilingRanges() {
		  return federalMarriedTogetherService.getAllFederalMarriedTogetherTax();
	  }
	  
	  @PostMapping("/calculateIncomeTax")
	  @ResponseStatus(HttpStatus.OK)
	  public double calculateIncomeTax(@RequestBody IncomeTaxRequest taxRequest) {
		  double totalIncomeTax = 0.00;
		  if(taxRequest != null && 
				  checkForNullOrEmpty(taxRequest.getStateName()) &&
				  checkForNullOrEmpty(taxRequest.getFilingStatus()) && 
				  checkForNullOrEmpty(taxRequest.getAnnualSalary())) {
			  totalIncomeTax = statesService.calculateIncomeTax(taxRequest, statesService.getAllStateInfo(),
					  federalSingleService.getAllFederalSingleTax(), 
					  federalMarriedTogetherService.getAllFederalMarriedTogetherTax());
		  }
		  return totalIncomeTax;
	  }
	  
	  private boolean checkForNullOrEmpty(String value) {
		  boolean isNotEmpty = false;
		  if(value != null && value != "") {
			  isNotEmpty = true;
		  }
		  return isNotEmpty;
	  }
	  
}
