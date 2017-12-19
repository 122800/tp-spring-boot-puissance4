package com.igs.ipi.tpspringbootnutakor.game;

public class Player {
	
	private int id;
	private String username = "default_username";
	
	private int victories;
	private int losses;
	private int points;
	//private String colour;

	public void addVictory(int hits) {
		victories++;
		points += hits;
	}

	public void addLoss() {
		losses++;
	}

}