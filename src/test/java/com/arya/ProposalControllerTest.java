package com.arya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.arya.controller.ProposalController;
import com.arya.entities.Proposal;
import com.arya.exception.ResourceNotFoundException;
import com.arya.repository.ProposalRepository;
import com.arya.service.ProposalService;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProposalControllerTest {
	@Autowired
	private ProposalService proposalService;
	@MockBean
	private ProposalRepository proposalRepository;
	@InjectMocks
	private ProposalController proposalController;
	

	@Test
	public void insertProposalTest() {
		Proposal proposal = new Proposal(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf");
		when(proposalRepository.save(proposal)).thenReturn(proposal);
		assertEquals(proposal, proposalService.insertProposal(proposal));
	}
	

	@Test
	public void getAllProposalTest() {
		when(proposalRepository.findAll()).thenReturn(Stream.of(new Proposal(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf")).collect(Collectors.toList()));
		assertEquals(1, proposalService.getAllProposal().size());
	}

	@Test
	public void getProposalByNameTest() throws ResourceNotFoundException {
		String proposalName= "Hridoy";
		when(proposalRepository.findByName(proposalName)).thenReturn(Stream.of(new Proposal(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf")).collect(Collectors.toList()));
		Assert.assertEquals(true, proposalService.getProposalByName(proposalName).toString().contains("Hridoy"));

}
	
	@Test
	public void getProposalBySummaryTest() throws ResourceNotFoundException {
		String proposalSummary= "fhghg";
		when(proposalRepository.findBySummary(proposalSummary)).thenReturn(Stream.of(new Proposal(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf")).collect(Collectors.toList()));
		Assert.assertEquals(true, proposalService.getProposalBySummary(proposalSummary).toString().contains("fhghg"));

}	
	@Test
	public void getProposalByDescriptionTest() throws ResourceNotFoundException {
		String proposalDescription= "cdcgf";
		when(proposalRepository.findByDescription(proposalDescription)).thenReturn(Stream.of(new Proposal(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf")).collect(Collectors.toList()));
		Assert.assertEquals(true, proposalService.getProposalByDescription(proposalDescription).toString().contains("cdcgf"));

}

	@Test
	public void getProposalByOwnerTest() throws ResourceNotFoundException {
		String proposalOwner= "kjhj";
		when(proposalRepository.findByOwner(proposalOwner)).thenReturn(Stream.of(new Proposal(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf")).collect(Collectors.toList()));
		Assert.assertEquals(true, proposalService.getProposalByOwner(proposalOwner).toString().contains("kjhj"));

}
	@Test
	public void getProposalByPriorityTest() throws ResourceNotFoundException {
		String proposalPriority= "hgf";
		when(proposalRepository.findByPriority(proposalPriority)).thenReturn(Stream.of(new Proposal(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf")).collect(Collectors.toList()));
		Assert.assertEquals(true, proposalService.getProposalByPriority(proposalPriority).toString().contains("hgf"));

    }
	
}