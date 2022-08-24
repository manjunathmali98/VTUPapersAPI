package com.linkit.vtu.service;

import org.springframework.stereotype.Service;

import com.linkit.vtu.entities.Qpaper;

@Service
public interface QPaperService {

	Qpaper getQpaperbyFileUrl(String fileUrl);

	Qpaper addQPaper(Qpaper qp);

}
