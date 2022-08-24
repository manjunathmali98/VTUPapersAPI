package com.linkit.vtu.DTO;

import java.util.List;

import com.linkit.vtu.entities.Paper;

public class SubjectDTO {

	private String subjectCode;
	
	private String subjectName;
	
	private List<Paper> papers;

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}
	
	
}
