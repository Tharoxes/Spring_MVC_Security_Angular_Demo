package com.Demo.Spring_MVC_Security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.Spring_MVC_Security.Entity.Candidate;

public interface CandidateRepository  extends JpaRepository<Candidate, Integer>{

}
