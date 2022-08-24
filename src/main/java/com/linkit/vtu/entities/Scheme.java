package com.linkit.vtu.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Scheme implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer schemeId;
	
	private String year;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scheme")
	private List<Branch> branches;
	
	public Scheme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scheme(Integer schemeId, String year, List<Branch> branches) {
		super();
		this.schemeId = schemeId;
		this.year = year;
		this.branches = branches;
	}

	public Integer getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(Integer schemeId) {
		this.schemeId = schemeId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Scheme [schemeId=" + schemeId + ", year=" + year + ", branches=" + branches + "]";
	}
	
	
}
