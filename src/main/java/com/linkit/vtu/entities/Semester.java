package com.linkit.vtu.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Semester implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer semesterId;
	
	private Integer sem;
		
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branchId")
	private Branch branch;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "semester")
	private List<Subject> subjects;

	public Semester() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Semester(Integer semesterId, Integer sem, Branch branch, List<Subject> subjects) {
		super();
		this.semesterId = semesterId;
		this.sem = sem;
		this.branch = branch;
		this.subjects = subjects;
	}

	public Semester(Semester sem2) {
		// TODO Auto-generated constructor stub
	}

	public Integer getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(Integer semesterId) {
		this.semesterId = semesterId;
	}
	
	public Integer getSem() {
		return sem;
	}

	public void setSem(Integer sem) {
		this.sem = sem;
	}
	
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
}
