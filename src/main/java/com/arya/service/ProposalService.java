package com.arya.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.arya.controller.ProposalController;
import com.arya.entities.Proposal;
import com.arya.exception.ResourceNotFoundException;
import com.arya.repository.ProposalRepository;
@Service
public class ProposalService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProposalController.class);

	@Autowired
	private ProposalRepository proposalRepository;
    

	public List<Proposal> getAllProposal(){
		LOGGER.info("Start process");
		  return this.proposalRepository.findAll();
		
	}

	public ResponseEntity<Proposal> getProposalById(Long proposalId)
			throws ResourceNotFoundException {
		
		LOGGER.info("Start process");
		   Proposal proposal = proposalRepository.findById(proposalId)
				.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this id :: " + proposalId));
		return ResponseEntity.ok().body(proposal);
	}
	

	public ResponseEntity<List<Proposal>> getProposalByName(String proposalName)
				throws ResourceNotFoundException {
			
			LOGGER.info("Start process");
			    List<Proposal> proposal = proposalRepository.findByName(proposalName);
					return ResponseEntity.ok().body(proposal);
		}
		
	
	public ResponseEntity<List<Proposal>> getProposalBySummary(String proposalSummary)
				throws ResourceNotFoundException {
		
			LOGGER.info("Start process");
			   List<Proposal> proposal = proposalRepository.findBySummary(proposalSummary);
					return ResponseEntity.ok().body(proposal);
		}
		
	
	public ResponseEntity<List<Proposal>> getProposalByDescription(String proposalDescription)
				throws ResourceNotFoundException {
		
			LOGGER.info("Start process");
			  List<Proposal> proposal = proposalRepository.findByDescription(proposalDescription);
					return ResponseEntity.ok().body(proposal);
		}
		
	
	public ResponseEntity<List<Proposal>> getProposalByOwner(String proposalOwner)
				throws ResourceNotFoundException {
		
			LOGGER.info("Start process");
			  List<Proposal> proposal = proposalRepository.findByOwner(proposalOwner);
					return ResponseEntity.ok().body(proposal);
		}
		
	
	public ResponseEntity<List<Proposal>> getProposalByPriority(String proposalPriority)
				throws ResourceNotFoundException {
		
			LOGGER.info("Start process");
			    List<Proposal> proposal = proposalRepository.findByPriority(proposalPriority);
					return ResponseEntity.ok().body(proposal);
		}
			
		

	public Proposal insertProposal(Proposal proposal) {
		LOGGER.info("Start process");
		   return proposalRepository.save(proposal);
	}

	public ResponseEntity<Proposal> updateProposal(Long proposalId,
			 Proposal proposalDetails) throws ResourceNotFoundException {
		
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

	public Map<String, Boolean> deleteProposalById(Long proposalId)
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
