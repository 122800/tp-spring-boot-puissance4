package com.igs.ipi.tpspringbootnutakor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	public Integer getId() {return id;}
	
	private String username;
	
	private Integer victories;
	private Integer losses;
	private Integer points;
	//private String colour;

	public void addVictory(int hits) {
		victories++;
		points += hits;
	}

	public void addLoss() {
		losses++;
	}
	
	public boolean equals(Player other) {
		return id == other.getId();
	}

}