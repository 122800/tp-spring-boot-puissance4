package com.igs.ipi.tpspringbootnutakor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.igs.ipi.tpspringbootnutakor.game.Direction;
import com.igs.ipi.tpspringbootnutakor.model.Jeton.PrimaryKey;

@Entity
//@PrimaryKeyJoinColumns({
//	@PrimaryKeyJoinColumn(name="x", referencedColumnName = "x"),
//	@PrimaryKeyJoinColumn(name="y", referencedColumnName = "y"),
//	@PrimaryKeyJoinColumn(name="game", referencedColumnName = "game_id"),
//	@PrimaryKeyJoinColumn(name="player", referencedColumnName = "player_id")
//})
@IdClass(PrimaryKey.class)
public class Jeton {
	
	public class PrimaryKey implements Serializable {
		private Integer x;
		private Integer y;
		private Game game;
		public Integer getX() {
			return x;
		}
		public void setX(Integer x) {
			this.x = x;
		}
		public Integer getY() {
			return y;
		}
		public void setY(Integer y) {
			this.y = y;
		}
		public Game getGame() {
			return game;
		}
		public void setGame(Game game) {
			this.game = game;
		}
	}

	@Id private Integer x;
	@Id private Integer y;
	
	@Id @ManyToOne
	private Game game;
	
	@OneToOne(targetEntity=Player.class)
	private Player player;
	
	public boolean belongsTo(Player p) {
		return player.equals(p);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param pId - player
	 * @param gId - gameId
	 */
	public Jeton(Integer x, Integer y, Player p, Game g) {
		this.x = x;
		this.y = y;
		game = g;
		player = p;
		
		checkSurroundings();
	}
	private void checkSurroundings() {
		int hits = 0;
		for(Direction dir : Direction.half()) {
			if(sendProbe(dir, player) >= 4) hits++;
		}
		if(hits > 0) {
			game.win(player, hits);
		}
	}
	
	private int sendProbe(Direction dir, Player p) {
		Jeton neighbour = getNeighbour(dir, p);
		if(neighbour != null) {
			return(neighbour.sendProbe(dir, p));
		} else {
			return countLine(dir.inverse(), p);
		}
	}	
	public int countLine(Direction dir, Player p) {
		if(!belongsTo(p)) return 0;
		int num = 1;
		Jeton neighbour = getNeighbour(dir, p);
		if(neighbour != null) {
			num += neighbour.countLine(dir, p);
		}
		return num;
	}
	
	private Jeton getNeighbour(Direction dir, Player p) {
		// may return null
		Jeton neighbour = game.getMap().getJeton(
			x + dir.x(),
			y + dir.y()
		);
		
		if(!neighbour.belongsTo(p)) return null;
		
		return neighbour;
	}
}