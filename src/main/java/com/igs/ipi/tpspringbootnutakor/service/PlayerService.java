package com.igs.ipi.tpspringbootnutakor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igs.ipi.tpspringbootnutakor.model.Player;
import com.igs.ipi.tpspringbootnutakor.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	public Player findById(Integer id) {
		return playerRepository.findById(id);
	}
	public Player findByUsername(String nom) {
		return playerRepository.findByUsername(nom);
	}
	
	public Player createOrUpdate(Player p) {
		return playerRepository.save(p);
	}
	public void delete(Player p) {
		playerRepository.delete(p);
	}
	
}