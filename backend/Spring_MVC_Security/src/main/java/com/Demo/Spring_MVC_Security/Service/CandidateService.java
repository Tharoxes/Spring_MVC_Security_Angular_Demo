package com.Demo.Spring_MVC_Security.Service;

import java.util.List;

import com.Demo.Spring_MVC_Security.Entity.Candidate;


public interface CandidateService {
	
	List<Candidate> findAll();
	Candidate findById(int theId);
	Candidate save(Candidate user);
	void deleteById (int theId);

}
