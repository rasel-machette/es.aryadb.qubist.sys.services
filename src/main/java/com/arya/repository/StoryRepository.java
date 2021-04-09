package com.arya.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.arya.entities.Story;
@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
	public List<Story> findByName(String name);
	public List<Story> findBySummary(String summary);
	public List<Story> findByDescription(String description);
	public List<Story> findByOwner(String owner);
	public List<Story> findByPriority(String priority);
	public List<Story> findByAssigned(String assigned);
	

}
