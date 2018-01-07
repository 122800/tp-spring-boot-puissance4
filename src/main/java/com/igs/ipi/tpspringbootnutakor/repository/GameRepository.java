package com.igs.ipi.tpspringbootnutakor.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.igs.ipi.tpspringbootnutakor.model.Game;
import com.igs.ipi.tpspringbootnutakor.model.Player;

public interface GameRepository extends PagingAndSortingRepository<Game, Serializable> {
	public Game findById(Integer id);
	public List<Game> findByPlayer1AndPlayer2(Player p1, Player p2);
}