package com.spring.app.employment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.employment.datamodel.FederalMarriedTogether;
import com.spring.app.employment.repository.FederalMarriedTogetherRepository;

@Service
public class FederalMarriedTogetherService {

	@Autowired
	FederalMarriedTogetherRepository federalMarriedTogetherRepository;
	
	public List<FederalMarriedTogether> getAllFederalMarriedTogetherTax() {
		List<FederalMarriedTogether> federalMarriedTogethers = new ArrayList<FederalMarriedTogether>();
		federalMarriedTogetherRepository.findAll().forEach(fedMarTogVal -> federalMarriedTogethers.add(fedMarTogVal));
		return federalMarriedTogethers;
	}
}
