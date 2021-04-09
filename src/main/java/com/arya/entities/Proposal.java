package com.arya.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver.Unique;

@Entity
@Table(name="proposal")
public class Proposal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Name")
	private String name;
	@Column(name = "Summary")
	private String summary;
	@Column(name = "Description")
	private String description;
	@Column(name = "Owner")
	private String owner;
	@Column(name = "Priority")
	private String priority;
	public Proposal() {
		super();
	}
	public Proposal(Long id, String name, String summary, String description, String owner, String priority) {
		super();
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.description = description;
		this.owner = owner;
		this.priority = priority;
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
	@Override
	public String toString() {
		return "Proposal [id=" + id + ", name=" + name + ", summary=" + summary + ", description=" + description
				+ ", owner=" + owner + ", priority=" + priority + "]";
	}
	

}
