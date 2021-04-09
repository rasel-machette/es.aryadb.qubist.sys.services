package com.arya.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.arya.entities.Proposal;
@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long>{
	public List<Proposal> findByName(String name);
	public List<Proposal> findBySummary(String summary);
	public List<Proposal> findByDescription(String description);
	public List<Proposal> findByOwner(String owner);
	public List<Proposal> findByPriority(String priority);
	
	
  
	}
