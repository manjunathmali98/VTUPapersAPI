package com.linkit.vtu.DTO;

import java.util.List;

public class SubjectResponseDTO {

	private List<SubjectPaperDTO> dec;
	
	private List<SubjectPaperDTO> jun;

	public List<SubjectPaperDTO> getDec() {
		return dec;
	}

	public void setDec(List<SubjectPaperDTO> dec) {
		this.dec = dec;
	}

	public List<SubjectPaperDTO> getJun() {
		return jun;
	}

	public void setJun(List<SubjectPaperDTO> jun) {
		this.jun = jun;
	}

	public SubjectResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectResponseDTO(List<SubjectPaperDTO> dec, List<SubjectPaperDTO> jun) {
		super();
		this.dec = dec;
		this.jun = jun;
	}
	
	
}
