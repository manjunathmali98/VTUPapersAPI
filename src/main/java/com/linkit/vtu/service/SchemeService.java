package com.linkit.vtu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.linkit.vtu.DTO.SchemeDTO;
import com.linkit.vtu.entities.Scheme;

@Service
public interface SchemeService {

	Scheme addScheme(Scheme sc);

	List<Scheme> getAllSchemes();

	Scheme getSchemeByYear(String year);

	List<SchemeDTO> findAllSchemes();
}
