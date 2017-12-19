package com.igs.ipi.tpspringbootnutakor.model;

import java.util.HashMap;

import com.igs.ipi.tpspringbootnutakor.game.Map;
import com.igs.ipi.tpspringbootnutakor.game.Player;

public class Game {
	
	private int id;
	private HashMap<Integer, Player> players;
	private int playerTurn = 1;
	
	private int w;
	private int h;
	private Map map;
	public Map map() {return map;}
	
	public Game(int id, Player p1, Player p2, int w, int h) {
		this.id = id;
		
		this.players = new HashMap<>();

		this.players.put(1, p1);
		this.players.put(2, p2);
		
		this.w = w;
		this.h = h;
		map = new Map(w, h, id);
	}
	
	public void win(int pId, int hits) {
		Player winner = players.get(pId);
		Player loser = players.get(otherId(pId));
		winner.addVictory(hits);
		loser.addLoss();
	}

	private int otherId(int pId) {
		return (pId == 1) ? 2 : 1;
	}
}