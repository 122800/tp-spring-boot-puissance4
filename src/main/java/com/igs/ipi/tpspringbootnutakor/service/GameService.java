package com.igs.ipi.tpspringbootnutakor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igs.ipi.tpspringbootnutakor.model.Game;
import com.igs.ipi.tpspringbootnutakor.model.Player;
import com.igs.ipi.tpspringbootnutakor.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public Game findByGameId(Integer id) {
		return gameRepository.findById(id);
	}
	public List<Game> findByPlayer1IdAndPlayer2Id(Player p1, Player p2) {
		return gameRepository.findByPlayer1AndPlayer2(p1, p2);
	}
	
	public Game newGame(Player p1, Player p2, Integer w, Integer h) {
		return gameRepository.save(new Game(p1, p2, w, h));
	}
}