package com.spring.app.employment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.employment.datamodel.FederalSingle;
import com.spring.app.employment.repository.FederalSingleRepository;

@Service
public class FederalSingleService {
	
	@Autowired
	FederalSingleRepository federalSingleRepository;
	
	public List<FederalSingle> getAllFederalSingleTax() {
		List<FederalSingle> federalSingles = new ArrayList<FederalSingle>();
		federalSingleRepository.findAll().forEach(singleVal -> federalSingles.add(singleVal));
		return federalSingles;
	}

}
