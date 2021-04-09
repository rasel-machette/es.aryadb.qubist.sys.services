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
import com.arya.entities.Story;
import com.arya.exception.ResourceNotFoundException;
import com.arya.service.StoryService;

@RestController
@RequestMapping("/response")
public class StoryController {
	@Autowired
	private StoryService storyService;
	
	//Get All
		 @GetMapping(
		   	        value = "/getStory",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		
		  public List<Story> getAllStory(){
			 
			return this.storyService.getAllStory();
			
		}	
		
	//Get using by id
	    @GetMapping(
		   	        value = "/getStoryById/{id}",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		
		 public ResponseEntity<Story> getStoryById(@PathVariable(value = "id") Long storyId)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryById(storyId);
		}
			//Get using by name
		 @GetMapping(
		   	        value = "/getStoryByName/{name}",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		
		 public ResponseEntity<List<Story>> getStoryByName(@PathVariable(value = "name") String storyName)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryByName(storyName);
		}
		
			//Get using by summary
		 @GetMapping(
		   	        value = "/getStoryBySummary/{summary}",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		
		 public ResponseEntity<List<Story>> getStoryBySummary(@PathVariable(value = "summary") String storySummary)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryBySummary(storySummary);
		}	 
		
			//Get using by Description
		 @GetMapping(
		   	        value = "/getStoryByDescription/{description}",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		
		 public ResponseEntity<List<Story>> getStoryByDescription(@PathVariable(value = "description") String storyDescription)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryByDescription(storyDescription);
		} 
		 
		 
			//Get using by Owner
		 @GetMapping(
		   	        value = "/getStoryByOwner/{owner}",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		
		 public ResponseEntity<List<Story>> getStoryByOwner(@PathVariable(value = "owner") String storyOwner)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryByOwner(storyOwner);
		} 
		 	 
			//Get using by Priority
		 @GetMapping(
		   	        value = "/getStoryByPriority/{priority}",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		
		 public ResponseEntity<List<Story>> getStoryByPriority(@PathVariable(value = "priority") String storyPriority)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryByPriority(storyPriority);
		} 	 
		 
			//Get using by Assignedy
		 @GetMapping(
		   	        value = "/getStoryByAssigned/{assigned}",
		   	        produces = MediaType.APPLICATION_JSON_VALUE)
		
		 public ResponseEntity<List<Story>> getStoryByAssigned(@PathVariable(value = "assigned") String storyAssigned)
				throws ResourceNotFoundException {
			 
			return storyService.getStoryByAssigned(storyAssigned);
		} 	 
		 
			 
		 
		 
		 
		 
		 
		 
		 
	  //Insert
		 @PostMapping(
	 	        value = "/insertStory",
	 	        consumes = MediaType.APPLICATION_JSON_VALUE)
		
		 public Story insertStory(@Validated @RequestBody Story story) {
			 
			return storyService.insertStory(story);
		}
		
	//Update
		 @PutMapping(
		 	        value = "/updateStory/{id}",
		 	        consumes = MediaType.APPLICATION_JSON_VALUE)
			
		
		 public ResponseEntity<Story> updateStory(@PathVariable(value = "id") Long storyId,
				@Validated @RequestBody Story storyDetails) throws ResourceNotFoundException {
			
			return storyService.updateStory(storyId, storyDetails);
			
		}
		
	//Delete	
		
		@DeleteMapping("/deleteStory/{id}")
		public Map<String, Boolean> deleteStory(@PathVariable(value = "id") Long storyId)
				throws ResourceNotFoundException {
			
			return storyService.deleteStory(storyId);


		}
	
	
	
	

}
