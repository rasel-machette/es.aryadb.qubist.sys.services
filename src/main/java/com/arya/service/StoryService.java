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
import com.arya.controller.StoryController;
import com.arya.entities.Proposal;
import com.arya.entities.Story;
import com.arya.exception.ResourceNotFoundException;
import com.arya.repository.StoryRepository;
@Service
public class StoryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StoryController.class);
	@Autowired
	private StoryRepository storyRepository;
	
	 
		//Get Proposal
		public List<Story> getAllStory(){
			LOGGER.info("Start process");
			return this.storyRepository.findAll();
			
		}
	//Get proposal using id
		public ResponseEntity<Story> getStoryById(@PathVariable(value = "id") Long storyId)
				throws ResourceNotFoundException {
			LOGGER.info("Start process");
			Story story = storyRepository.findById(storyId)
					.orElseThrow(() -> new ResourceNotFoundException("Story not found for this id :: " + storyId));
			  return ResponseEntity.ok().body(story);
		}
		
	//Get proposal using name
		public ResponseEntity<List<Story>> getStoryByName(@PathVariable(value = "name") String storyName)
				throws ResourceNotFoundException {
			LOGGER.info("Start process");
			List<Story> story = storyRepository.findByName(storyName);
							//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
				return ResponseEntity.ok().body(story);
					
		}
	//Get proposal using summary
		public ResponseEntity<List<Story>> getStoryBySummary(@PathVariable(value = "summary") String storySummary)
				throws ResourceNotFoundException {
			LOGGER.info("Start process");
			List<Story> story = storyRepository.findBySummary(storySummary);
							//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
				return ResponseEntity.ok().body(story);
				
		}
		
	//Get proposal using Description
	   public ResponseEntity<List<Story>> getStoryByDescription(@PathVariable(value = "description") String storyDescription)
			  throws ResourceNotFoundException {
		 LOGGER.info("Start process");
		 List<Story> story = storyRepository.findByDescription(storyDescription);
						//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
			return ResponseEntity.ok().body(story);
			
	}			
	   
		//Get proposal using Owner
	   public ResponseEntity<List<Story>> getStoryByOwner(@PathVariable(value = "owner") String storyOwner)
			  throws ResourceNotFoundException {
		 LOGGER.info("Start process");
		 List<Story> story = storyRepository.findByOwner(storyOwner);
						//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
			return ResponseEntity.ok().body(story);
			
	}
	
		//Get proposal using Priority
	   public ResponseEntity<List<Story>> getStoryByPriority(@PathVariable(value = "priority") String storyPriority)
			  throws ResourceNotFoundException {
		 LOGGER.info("Start process");
		 List<Story> story = storyRepository.findByPriority(storyPriority);
						//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
			return ResponseEntity.ok().body(story);
			
	}   
	   
		//Get proposal using Assigned
	   public ResponseEntity<List<Story>> getStoryByAssigned(@PathVariable(value = "assigned") String storyAssigned)
			  throws ResourceNotFoundException {
		 LOGGER.info("Start process");
		 List<Story> story = storyRepository.findByAssigned(storyAssigned);
						//.orElseThrow(() -> new ResourceNotFoundException("Proposal not found for this name :: " + proposalName));
			return ResponseEntity.ok().body(story);
			
	}   
	   
	   
	   
	   
	   
	   
	   
	   
	 //Insert
		public Story insertStory(@Validated @RequestBody Story story) {
			LOGGER.info("Start process");
			return storyRepository.save(story);
		}
	//Update
		public ResponseEntity<Story> updateStory(@PathVariable(value = "id") Long storyId,
				@Validated @RequestBody Story storyDetails) throws ResourceNotFoundException {
			LOGGER.info("Start process");
			Story story = storyRepository.findById(storyId)
					.orElseThrow(() -> new ResourceNotFoundException("Story not found for this id :: " + storyId));

			story.setId(storyDetails.getId());
			story.setName(storyDetails.getName());
			story.setSummary(storyDetails.getSummary());
			story.setDescription(storyDetails.getDescription());
			story.setOwner(storyDetails.getOwner());
			story.setPriority(storyDetails.getPriority());
			story.setAssigned(storyDetails.getAssigned());
			final Story updatedStory = storyRepository.save(story);
			return ResponseEntity.ok(updatedStory);
		}
	//Delete
		public Map<String, Boolean> deleteStory(@PathVariable(value = "id") Long storyId)
				throws ResourceNotFoundException {
			LOGGER.info("Start process");
			Story story = storyRepository.findById(storyId)
					.orElseThrow(() -> new ResourceNotFoundException("Story not found for this id :: " + storyId));

			storyRepository.delete(story);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
		

}
