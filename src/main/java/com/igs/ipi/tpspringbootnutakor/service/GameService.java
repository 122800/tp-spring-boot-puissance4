package com.igs.ipi.tpspringbootnutakor.service;

import org.springframework.stereotype.Service;

import com.igs.ipi.tpspringbootnutakor.model.GameModel;

@Service
public class GameService {
	
	public GameService() {}
	
	public GameModel newGame() {
		return new GameModel("player1", "player2");
	}
}