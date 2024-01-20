package com.Demo.Spring_MVC_Security.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.Spring_MVC_Security.Entity.Candidate;
import com.Demo.Spring_MVC_Security.Repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService{
	
	private CandidateRepository candidateRepository;
	
	@Autowired
	public CandidateServiceImpl (CandidateRepository theCandidateRepository) {
		candidateRepository = theCandidateRepository;
	}
	
	@Override
	public List<Candidate> findAll(){
		return candidateRepository.findAll();
	}
	
	@Override
	public Candidate findById(int theId) {
		Optional<Candidate> result = candidateRepository.findById(theId);
		Candidate candidate = null;
		
		if(result.isPresent()) {
			candidate = result.get();
		}else {
			throw new RuntimeException("Did not find candidate ID: " + theId);
		}
		
		return candidate;
	}
	
	@Override
	public Candidate save(Candidate candidate) {
		return candidateRepository.save(candidate);
	}
	
	@Override
	public void deleteById(int theId) {
		candidateRepository.deleteById(theId);;
	}

}
