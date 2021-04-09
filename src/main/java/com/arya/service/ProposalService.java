package com.arya.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.arya.controller.ProposalController;
import com.arya.entities.Proposal;
import com.arya.exception.ResourceNotFoundException;
import com.arya.repository.ProposalRepository;
@Service
public class ProposalService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProposalController.class);

	@Autowired
	private ProposalRepository proposalRepository;
    
	//Get Proposal
	public List<Proposal> getAllProposal(){
		LOGGER.info("Start process");
		return this.proposalRepository.findAll();
		
	}
//Get proposal using id
	public ResponseEntity<Proposal> getProposalById(@PathVariable(value = "id") Long proposalId)
			throws ResourceNotFoundException {
		LOGGER.info("Start process");
		Proposal proposal = proposalRepository.findById(proposalId)
				.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this id :: " + proposalId));
		return ResponseEntity.ok().body(proposal);
	}
	
	//Get proposal using name
		public ResponseEntity<List<Proposal>> getProposalByName(@PathVariable(value = "name") String proposalName)
				throws ResourceNotFoundException {
			LOGGER.info("Start process");
			List<Proposal> proposal = proposalRepository.findByName(proposalName);
					//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
			return ResponseEntity.ok().body(proposal);
		}
		
		//Get proposal using summary
		public ResponseEntity<List<Proposal>> getProposalBySummary(@PathVariable(value = "summary") String proposalSummary)
				throws ResourceNotFoundException {
			LOGGER.info("Start process");
			List<Proposal> proposal = proposalRepository.findBySummary(proposalSummary);
					//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
			return ResponseEntity.ok().body(proposal);
		}
		
		//Get proposal using description
		public ResponseEntity<List<Proposal>> getProposalByDescription(@PathVariable(value = "description") String proposalDescription)
				throws ResourceNotFoundException {
			LOGGER.info("Start process");
			List<Proposal> proposal = proposalRepository.findByDescription(proposalDescription);
					//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
			return ResponseEntity.ok().body(proposal);
		}
		
		//Get proposal using owner
		public ResponseEntity<List<Proposal>> getProposalByOwner(@PathVariable(value = "owner") String proposalOwner)
				throws ResourceNotFoundException {
			LOGGER.info("Start process");
			List<Proposal> proposal = proposalRepository.findByOwner(proposalOwner);
					//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
			return ResponseEntity.ok().body(proposal);
		}
		
		//Get proposal using Priority
		public ResponseEntity<List<Proposal>> getProposalByPriority(@PathVariable(value = "priority") String proposalPriority)
				throws ResourceNotFoundException {
			LOGGER.info("Start process");
			List<Proposal> proposal = proposalRepository.findByPriority(proposalPriority);
					//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
			return ResponseEntity.ok().body(proposal);
		}
			
		
//Insert
	public Proposal insertProposal(@Validated @RequestBody Proposal proposal) {
		LOGGER.info("Start process");
		return proposalRepository.save(proposal);
	}
//Update
	public ResponseEntity<Proposal> updateProposal(@PathVariable(value = "id") Long proposalId,
			@Validated @RequestBody Proposal proposalDetails) throws ResourceNotFoundException {
		LOGGER.info("Start process");
		Proposal proposal = proposalRepository.findById(proposalId)
				.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this id :: " + proposalId));

		proposal.setId(proposalDetails.getId());
		proposal.setName(proposalDetails.getName());
		proposal.setSummary(proposalDetails.getSummary());
		proposal.setDescription(proposalDetails.getDescription());
		proposal.setOwner(proposalDetails.getOwner());
		proposal.setPriority(proposalDetails.getPriority());
		final Proposal updatedProposal = proposalRepository.save(proposal);
		return ResponseEntity.ok(updatedProposal);
	}
//Delete
	public Map<String, Boolean> deleteProposal(@PathVariable(value = "id") Long proposalId)
			throws ResourceNotFoundException {
		LOGGER.info("Start process");
		Proposal proposal = proposalRepository.findById(proposalId)
				.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this id :: " + proposalId));

		proposalRepository.delete(proposal);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	

}
