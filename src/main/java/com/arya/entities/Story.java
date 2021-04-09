package com.arya.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Story {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String summary;
	private String description;
	private String owner;
	private String priority;
	private String assigned;
	
	

	public Story() {
		super();
	}
	public Story(Long id, String name, String summary, String description, String owner, String priority, String assigned) {
		super();
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.description = description;
		this.owner = owner;
		this.priority = priority;
		this.assigned = assigned;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getAssigned() {
		return assigned;
	}
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}
	@Override
	public String toString() {
		return "Story [id=" + id + ", name=" + name + ", summary=" + summary + ", description=" + description
				+ ", owner=" + owner + ", priority=" + priority + ", assigned=" + assigned + "]";
	}
	
	
}
