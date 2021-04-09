package com.arya.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arya.entities.Proposal;
import com.arya.exception.ResourceNotFoundException;
import com.arya.service.ProposalService;


@RestController
@RequestMapping("/response")
public class ProposalController {
	
	@Autowired
	private ProposalService proposalService;
	
	//Get All
	 @GetMapping(
	   	        value = "/getProposals",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	
	  public List<Proposal> getAllProposal(){
		 
		return this.proposalService.getAllProposal();
		
	}	
	
	//Get using by id
	 @GetMapping(
	   	        value = "/getProposalById/{id}",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	
	 public ResponseEntity<Proposal> getProposalById(@PathVariable(value = "id") Long proposalId)
			throws ResourceNotFoundException {
		 
		return proposalService.getProposalById(proposalId);
	}
	
		//Get using by name
	 @GetMapping(
	   	        value = "/getProposalByName/{name}",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	
	 public ResponseEntity<List<Proposal>> getProposalByName(@PathVariable(value = "name") String proposalName)
			throws ResourceNotFoundException {
		 
		return proposalService.getProposalByName(proposalName);
	}
	
		//Get using by summary
	 @GetMapping(
	   	        value = "/getProposalBySummary/{summary}",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	
	 public ResponseEntity<List<Proposal>> getProposalBySummary(@PathVariable(value = "summary") String proposalSummary)
			throws ResourceNotFoundException {
		 
		return proposalService.getProposalBySummary(proposalSummary);
	}	 
	 	 
	 
		//Get using by description
	 @GetMapping(
	   	        value = "/getProposalByDescription/{description}",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	
	 public ResponseEntity<List<Proposal>> getProposalByDescription(@PathVariable(value = "description") String proposalDescription)
			throws ResourceNotFoundException {
		 
		return proposalService.getProposalByDescription(proposalDescription);
	}	 
	
		//Get using by Owner
	 @GetMapping(
	   	        value = "/getProposalByOwner/{owner}",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	
	 public ResponseEntity<List<Proposal>> getProposalByOwner(@PathVariable(value = "owner") String proposalOwner)
			throws ResourceNotFoundException {
		 
		return proposalService.getProposalByOwner(proposalOwner);
	}
	 
		//Get using by Priority
	 @GetMapping(
	   	        value = "/getProposalByPriority/{priority}",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	
	 public ResponseEntity<List<Proposal>> getProposalByPriority(@PathVariable(value = "priority") String proposalPriority)
			throws ResourceNotFoundException {
		 
		return proposalService.getProposalByPriority(proposalPriority);
	}
	 
  //Insert
	 @PostMapping(
 	        value = "/insertProposal",
 	        consumes = MediaType.APPLICATION_JSON_VALUE)
	
	 public Proposal insertProposal(@Validated @RequestBody Proposal proposal) {
		 
		return proposalService.insertProposal(proposal);
	}
	
//Update
	 @PutMapping(
	 	        value = "/updateProposal/{id}",
	 	        consumes = MediaType.APPLICATION_JSON_VALUE)
		
	
	 public ResponseEntity<Proposal> updateProposal(@PathVariable(value = "id") Long proposalId,
			@Validated @RequestBody Proposal proposalDetails) throws ResourceNotFoundException {
		
		return proposalService.updateProposal(proposalId, proposalDetails);
		
	}
	
//Delete	
	
	@DeleteMapping("/deleteProposal/{id}")
	public Map<String, Boolean> deleteProposal(@PathVariable(value = "id") Long proposalId)
			throws ResourceNotFoundException {
		
		return proposalService.deleteProposal(proposalId);


	}
	
}
