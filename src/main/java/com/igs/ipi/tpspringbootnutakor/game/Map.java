package com.igs.ipi.tpspringbootnutakor.game;

import org.springframework.beans.factory.annotation.Autowired;

import com.igs.ipi.tpspringbootnutakor.exceptions.MapException;
import com.igs.ipi.tpspringbootnutakor.exceptions.OutOfBoundsException;
import com.igs.ipi.tpspringbootnutakor.exceptions.SpotOccupiedException;
import com.igs.ipi.tpspringbootnutakor.model.Game;
import com.igs.ipi.tpspringbootnutakor.model.Jeton;
import com.igs.ipi.tpspringbootnutakor.model.Player;
import com.igs.ipi.tpspringbootnutakor.service.JetonService;

public class Map {
	
	@Autowired
	private JetonService jetonService;

	private Game game;
	private Integer w;
	private Integer h;
	
	private int load;
	private int capacity;
	private Jeton[][] jetons;

	public Map(Integer w, Integer h, Game g) {
		this.w = w;
		this.h = h;
		capacity = w * h;
		load = 0;
		game = g;
		jetons = new Jeton[w][h];
	}
	
	public boolean full() {
		return load >= capacity;
	}
	
	public void spawnJeton(Integer x, Integer y, Player player) throws MapException {
		if(!inBounds(x, y)) throw new OutOfBoundsException(x, y);
		if(getJeton(x, y) != null) throw new SpotOccupiedException(x, y);
		jetons[x][y] = jetonService.create(new Jeton(x, y, player, game));
		load++;
	}
	
	public Jeton getJeton(Integer x, Integer y) {
		if(inBounds(x, y) && jetons[x][y] != null) {
			return jetons[x][y];
		}
		return null;
	}
	
	private boolean inBounds(Integer x, Integer y) {
		return (0 <= x && x < w && 0 <= y && y < h);
	}
	
}