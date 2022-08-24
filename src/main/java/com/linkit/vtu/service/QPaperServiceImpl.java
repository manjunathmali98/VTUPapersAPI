package com.linkit.vtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkit.vtu.entities.Paper;
import com.linkit.vtu.entities.Qpaper;
import com.linkit.vtu.repository.QpaperRepository;

@Service
public class QPaperServiceImpl implements QPaperService {

	@Autowired
	QpaperRepository qpRepo;
	
	@Autowired
	PaperService paperService;

	@Override
	public Qpaper getQpaperbyFileUrl(String fileUrl) throws NullPointerException {
		
		Paper paper = paperService.getByfileUrl(fileUrl);
		if(paper.equals(null))
		{
			return null;
		}
		else {
			Qpaper qpaper = qpRepo.getBypaper(paper);
			if(qpaper.equals(null))
				return null;
		
		return qpaper;
		}
	}

	@Override
	public Qpaper addQPaper(Qpaper qp) {
		
		return qpRepo.save(qp);
	}
	

}
