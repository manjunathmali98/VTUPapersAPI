package com.linkit.vtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.linkit.vtu.entities.Paper;
import com.linkit.vtu.entities.Qpaper;

public interface QpaperRepository extends JpaRepository<Qpaper, Integer> {
	
	Qpaper getBypaper(Paper paper);

}
