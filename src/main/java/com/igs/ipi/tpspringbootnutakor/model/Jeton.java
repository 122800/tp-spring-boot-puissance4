package com.igs.ipi.tpspringbootnutakor.model;

import com.igs.ipi.tpspringbootnutakor.game.Direction;

public class Jeton {

	private int x;
	private int y;
	private int playerId;
	public boolean belongsTo(int pId) {return playerId == pId;}
	private Game game;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param pId - playerId
	 * @param gId - gameId
	 */
	public Jeton(int x, int y, int pId, int gId) {
		this.x = x;
		this.y = y;
		playerId = pId;
		
		checkSurroundings();
	}
	private void checkSurroundings() {
		int hits = 0;
		for(Direction dir : Direction.half()) {
			if(sendProbe(dir, playerId) >= 4) hits++;
		}
		if(hits > 0) {
			game.win(playerId, hits);
		}
	}
	
	private int sendProbe(Direction dir, int pId) {
		Jeton neighbour = getNeighbour(dir, pId);
		if(neighbour != null) {
			return(neighbour.sendProbe(dir, pId));
		} else {
			return countLine(dir.inverse(), pId);
		}
	}	
	public int countLine(Direction dir, int pId) {
		if(!belongsTo(pId)) return 0;
		int num = 1;
		Jeton neighbour = getNeighbour(dir, pId);
		if(neighbour != null) {
			num += neighbour.countLine(dir, pId);
		}
		return num;
	}
	
	private Jeton getNeighbour(Direction dir, int pId) {
		Jeton j = game.map().getJeton(x+dir.x(), y+dir.y());
		if(!j.belongsTo(pId)) return null;
		return j;
	}
}