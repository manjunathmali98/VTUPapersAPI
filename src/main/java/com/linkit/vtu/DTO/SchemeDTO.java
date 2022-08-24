package com.linkit.vtu.DTO;

public class SchemeDTO {
	
	private Integer schemeId;
	
	private String year;

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

	@Override
	public String toString() {
		return "SchemeDTO [schemeId=" + schemeId + ", year=" + year + "]";
	}
}
