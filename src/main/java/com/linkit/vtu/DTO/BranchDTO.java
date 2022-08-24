package com.linkit.vtu.DTO;

import java.util.List;

public class BranchDTO {

	private Integer branchId;
	
	private String branchName;
	
	private String shortCode;
	
	private List<SemesterDTO> semesters;

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

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public List<SemesterDTO> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<SemesterDTO> semesters) {
		this.semesters = semesters;
	}
}
