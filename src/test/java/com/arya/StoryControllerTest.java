package com.arya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.arya.controller.StoryController;
import com.arya.entities.Story;
import com.arya.exception.ResourceNotFoundException;
import com.arya.repository.StoryRepository;
import com.arya.service.StoryService;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoryControllerTest {
	@Autowired
	private StoryService storyService;
	@MockBean
	private StoryRepository storyRepository;
	@InjectMocks
	private StoryController storyController;
	
	
	@Test
	public void insertStoryTest() {
		Story story = new Story(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf","ghg");
		when(storyRepository.save(story)).thenReturn(story);
		assertEquals(story, storyService.insertStory(story));
	}
	
	@Test
	public void getAllStoryTest() {
		when(storyRepository.findAll()).thenReturn(Stream.of(new Story(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf","ghg")).collect(Collectors.toList()));
		assertEquals(1, storyService.getAllStory().size());
	}
	
	@Test
	public void getStoryByNameTest() throws ResourceNotFoundException {
		String storyName= "Hridoy";
		when(storyRepository.findByName(storyName)).thenReturn(Stream.of(new Story(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf","ghg")).collect(Collectors.toList()));
		Assert.assertEquals(true, storyService.getStoryByName(storyName).toString().contains("Hridoy"));

}
	
	@Test
	public void getStoryBySummaryTest() throws ResourceNotFoundException {
		String storySummary= "fhghg";
		when(storyRepository.findBySummary(storySummary)).thenReturn(Stream.of(new Story(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf","ghg")).collect(Collectors.toList()));
		Assert.assertEquals(true, storyService.getStoryBySummary(storySummary).toString().contains("fhghg"));

}	
	@Test
	public void getStoryByDescriptionTest() throws ResourceNotFoundException {
		String storyDescription= "cdcgf";
		when(storyRepository.findByDescription(storyDescription)).thenReturn(Stream.of(new Story(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf","ghg")).collect(Collectors.toList()));
		Assert.assertEquals(true, storyService.getStoryByDescription(storyDescription).toString().contains("cdcgf"));

}

	@Test
	public void getStoryByOwnerTest() throws ResourceNotFoundException {
		String storyOwner= "kjhj";
		when(storyRepository.findByOwner(storyOwner)).thenReturn(Stream.of(new Story(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf","ghg")).collect(Collectors.toList()));
		Assert.assertEquals(true, storyService.getStoryByOwner(storyOwner).toString().contains("kjhj"));

}
	@Test
	public void getStoryByPriorityTest() throws ResourceNotFoundException {
		String storyPriority= "hgf";
		when(storyRepository.findByPriority(storyPriority)).thenReturn(Stream.of(new Story(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf","ghg")).collect(Collectors.toList()));
		Assert.assertEquals(true, storyService.getStoryByPriority(storyPriority).toString().contains("hgf"));

}
	@Test
	public void getStoryByAssignedTest() throws ResourceNotFoundException {
		String storyAssigned= "ghg";
		when(storyRepository.findByAssigned(storyAssigned)).thenReturn(Stream.of(new Story(5L,"Hridoy","fhghg","cdcgf","kjhj","hgf","ghg")).collect(Collectors.toList()));
		Assert.assertEquals(true, storyService.getStoryByAssigned(storyAssigned).toString().contains("ghg"));

   }
	
}
