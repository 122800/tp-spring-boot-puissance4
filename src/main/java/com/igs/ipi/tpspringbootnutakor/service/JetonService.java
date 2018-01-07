package com.igs.ipi.tpspringbootnutakor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igs.ipi.tpspringbootnutakor.model.Jeton;
import com.igs.ipi.tpspringbootnutakor.repository.JetonRepository;

@Service
public class JetonService {

	@Autowired
	private JetonRepository JetonRepository;
	
	public Jeton findByGameIdAndXAndY(Integer id) {
		return JetonRepository.findByGameIdAndXAndY(id);
	}
	
	public Jeton create(Jeton p) {
		return JetonRepository.save(p);
	}
	
}