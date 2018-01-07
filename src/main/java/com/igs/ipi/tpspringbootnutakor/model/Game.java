package com.igs.ipi.tpspringbootnutakor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.igs.ipi.tpspringbootnutakor.game.Map;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(targetEntity = Player.class)
	private Player player1;
	@OneToOne(targetEntity = Player.class)
	private Player player2;
	
	private Integer width;
	private Integer height;
	
	@Transient
	private Player currentPlayer;
	
	@Transient
	private Map map;
	public Map getMap() {return map;}
	
	public Game(Player p1, Player p2, Integer w, Integer h) {

		player1 = p1;
		player2 = p2;
		
		width = w;
		height = h;
		map = new Map(w, h, this);
	}
	
	public void win(Player winner, int hits) {
		
		winner.addVictory(hits);
		
		if(player1.equals(winner)) {
			player2.addLoss();
		} else {
			player1.addLoss();
		}
	}

	private Player otherPlayer(Player p) {
		return player1.equals(p) ? player2 : player1;
	}
}