package com.igs.ipi.tpspringbootnutakor.game;

import com.igs.ipi.tpspringbootnutakor.exceptions.MapException;
import com.igs.ipi.tpspringbootnutakor.exceptions.OutOfBoundsException;
import com.igs.ipi.tpspringbootnutakor.exceptions.SpotOccupiedException;
import com.igs.ipi.tpspringbootnutakor.model.Jeton;

public class Map {

	private int gameId;
	private int w;
	private int h;
	
	private int load;
	private int capacity;
	private Jeton[][] jetons;

	public Map(int w, int h, int gId) {
		this.w = w;
		this.h = h;
		capacity = w * h;
		load = 0;
		gameId = gId;
		jetons = new Jeton[w][h];
	}
	
	public boolean full() {
		return load >= capacity;
	}
	
	public void spawnJeton(int x, int y, int pId) throws MapException {
		if(!inBounds(x, y)) throw new OutOfBoundsException(x, y);
		if(getJeton(x, y) != null) throw new SpotOccupiedException(x, y);
		jetons[x][y] = new Jeton(x, y, pId, gameId);
		load++;
	}
	
	public Jeton getJeton(int x, int y) {
		if(inBounds(x, y) && jetons[x][y] != null) {
			return jetons[x][y];
		}
		return null;
	}
	
	private boolean inBounds(int x, int y) {
		return (0 <= x && x < w && 0 <= y && y < h);
	}
	
}