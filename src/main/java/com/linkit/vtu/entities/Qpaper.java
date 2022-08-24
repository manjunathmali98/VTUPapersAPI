package com.linkit.vtu.entities;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Qpaper implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qpaperId;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fileUrl")
	private Paper paper;
	
	@Lob
	private byte[] dataFile;

	public Qpaper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Qpaper(Integer qpaperId, Paper paper, byte[] dataFile) {
		super();
		this.qpaperId = qpaperId;
		this.paper = paper;
		this.dataFile = dataFile;
	}

	public Integer getQpaperId() {
		return qpaperId;
	}

	public void setQpaperId(Integer qpaperId) {
		this.qpaperId = qpaperId;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public byte[] getDataFile() {
		return dataFile;
	}

	public void setDataFile(byte[] dataFile) {
		this.dataFile = dataFile;
	}

	
}
