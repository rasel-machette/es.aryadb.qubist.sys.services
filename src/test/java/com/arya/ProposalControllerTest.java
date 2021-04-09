package com.arya;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.arya.controller.ProposalController;
import com.arya.service.ProposalService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProposalControllerTest {
	
	@LocalServerPort
	int randomServerPort;
	String proposalUri = "http://localhost:8080/response/";
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private ProposalService proposalService;
	@InjectMocks
	private ProposalController proposalController;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(proposalController).build();
	}
	
	@Test
	public void testgetProposals() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = proposalUri + "/getProposals";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("Hridoy"));
	}
	
	
	

}
