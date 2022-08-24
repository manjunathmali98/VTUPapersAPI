package com.linkit.vtu.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Subject implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subjectId;
	
	private String subjectCode;
	
	private String subjectName;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semesterId")
	private Semester semester;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subject")
	private List<Paper> papers;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Subject(Integer subjectId, String subjectCode, String subjectName, Semester semester, List<Paper> papers) {
		super();
		this.subjectId = subjectId;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.semester = semester;
		this.papers = papers;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName
				+ "]";
	}

	
}
