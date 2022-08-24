package com.linkit.vtu.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Paper implements Serializable{

	//private Integer paperId;
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subjectId")
	private Subject subject;
	
	private String subjectCode;
	private String month;
	private String year;
	
	@Id
	private String fileUrl;
	
	/*
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paper")
	private Qpaper qpaper;
	*/
	public Paper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paper(Subject subject, String month, String year, String fileUrl) {
		super();
		this.subject = subject;
		this.month = month;
		this.year = year;
		this.fileUrl = fileUrl;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Paper(Subject subject, String subjectCode, String month, String year, String fileUrl) {
		super();
		this.subject = subject;
		this.subjectCode = subjectCode;
		this.month = month;
		this.year = year;
		this.fileUrl = fileUrl;
	}

	@Override
	public String toString() {
		return "Paper { subjectCode=" + subjectCode + ", month=" + month + ", year=" + year
				+ ", fileUrl=" + fileUrl + "}";
	}
	
}
