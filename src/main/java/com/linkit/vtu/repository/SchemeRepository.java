package com.linkit.vtu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.linkit.vtu.DTO.SchemeDTO;
import com.linkit.vtu.entities.Scheme;

public interface SchemeRepository extends JpaRepository<Scheme, Integer> {
	
	
	Scheme findByYear(String year);
	
	@Modifying
	@Query(value="select scheme_id,year from scheme order by scheme_id desc", nativeQuery = true)
	List<Scheme> findAllSchemes();
}
