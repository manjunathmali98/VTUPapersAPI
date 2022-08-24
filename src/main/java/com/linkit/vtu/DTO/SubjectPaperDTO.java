package com.linkit.vtu.DTO;

import com.linkit.vtu.entities.Paper;


/*
 * 
 * //  getsubjects/semId
[
 dec : [ List<subjectPaperDTO> ],
 jun : [ List<subjectPaperDTO> ]
]

// papers/{search}

[
 List<subjectPapersDTO> // paper.orderByYearLatest
]
 */
public class SubjectPaperDTO {
	
	private Integer subjectId;
	
	private String subjectCode;
	
	private String subjectName;
	
	private Paper paper;	
	
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

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public SubjectPaperDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectPaperDTO(Integer subjectId, String subjectCode, String subjectName, Paper paper) {
		super();
		this.subjectId = subjectId;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.paper = paper;
	}

	@Override
	public String toString() {
		return "SubjectPaperDTO { subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectName="
				+ subjectName + ", paper=" + paper + "}";
	}


}
