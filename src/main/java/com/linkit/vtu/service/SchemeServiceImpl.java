package com.linkit.vtu.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.linkit.vtu.DTO.SchemeDTO;
import com.linkit.vtu.entities.Scheme;
import com.linkit.vtu.repository.SchemeRepository;

@Service
public class SchemeServiceImpl implements SchemeService {
	
	@Autowired
	SchemeRepository schemeRepo;
	
	@Override
	public Scheme addScheme(Scheme sc) {
		
		return schemeRepo.save(sc);
	}

	
	@Override
	public List<Scheme> getAllSchemes() {
		
		return schemeRepo.findAll();
	}


	@Override
	public Scheme getSchemeByYear(String year) {
		
		return schemeRepo.findByYear(year);
	}

	
	@Override
	public List<SchemeDTO> findAllSchemes() {
				
		List<Scheme> schemes = schemeRepo.findAllSchemes();
		System.out.println(schemes);
		List<SchemeDTO> allSchemes = new ArrayList<SchemeDTO>();
		
		ModelMapper modelMapper = new ModelMapper();
		
		for (Scheme Obj : schemes) {
			
			SchemeDTO scheme = modelMapper.map(Obj, SchemeDTO.class);
			allSchemes.add(scheme);
		}
		
		return allSchemes;
	}

}
