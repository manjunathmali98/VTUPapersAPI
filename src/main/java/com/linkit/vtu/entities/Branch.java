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
public class Branch implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer branchId;
	
	private String branchName;
	
	private String shortCode;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schemeId")
	private Scheme scheme;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "branch")
	private List<Semester> semesters;
	
	
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Branch(Integer branchId, String branchName, Scheme scheme, List<Semester> semesters) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.scheme = scheme;
		this.semesters = semesters;
	}



	public List<Semester> getSemesters() {
		return semesters;
	}



	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}



	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}



	public String getShortCode() {
		return shortCode;
	}



	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	
	
	//private List<Semester> semesters;
	
	
}
