package com.igs.ipi.tpspringbootnutakor.service;

import org.springframework.stereotype.Service;

import com.igs.ipi.tpspringbootnutakor.game.Player;
import com.igs.ipi.tpspringbootnutakor.model.Game;

@Service
public class GameService {
	
	public GameService() {}
	
	public Game newGame(Player p1, Player p2) {
		return new Game(0, p1, p2, 0, 0);
	}
}