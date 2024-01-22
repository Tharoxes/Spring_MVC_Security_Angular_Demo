package com.Demo.Spring_MVC_Security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.Spring_MVC_Security.Entity.Candidate;
import com.Demo.Spring_MVC_Security.Service.CandidateService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class DemoCandidateController {
	
	private CandidateService candidateService;
	private UserDetailsService userDetailsService;
	
	@Autowired
	public DemoCandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return
          user.getUsername().equals("user") && user.getPassword().equals("password");
    }
	
	@GetMapping("/candidates")
	public List<Candidate> getCandidates(){
		return candidateService.findAll();
	}
	
	@GetMapping("/candidates/{candidateId}")
	public Candidate getCandidate(@PathVariable int candidateId) {
		Candidate theCandidate = candidateService.findById(candidateId);
		
		if (theCandidate == null) {
			throw new RuntimeException("Candidate id not found: " + candidateId);
		}
		
		return theCandidate;
	}
	
	@PostMapping("/candidates")
	public Candidate addCandidate(@RequestBody Candidate c) {
		c.setId(0);
		Candidate dbCandidate = candidateService.save(c);
		return dbCandidate;
	}
	
	@PutMapping("/candidates")
	public Candidate updateCandidate(@RequestBody Candidate c) {
		Candidate dbCandidate = candidateService.save(c);
		return dbCandidate;
	}
	
	@DeleteMapping("/candidates/{candidateId}")
	public String deleteCandidate(@PathVariable int candidateId) {
		Candidate tempCandidate = candidateService.findById(candidateId);
		
		if(tempCandidate == null) {
			throw new RuntimeException("Candidate not found with ID: " + candidateId);
		}else {
			candidateService.deleteById(candidateId);
		}
		
		return "Cadidate removed. Id: " + candidateId;
	}

}
