package com.igs.ipi.tpspringbootnutakor.repository;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.igs.ipi.tpspringbootnutakor.model.Player;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Serializable> {
	public Player findById(Integer id);
	public Player findByUsername(String nom);
}