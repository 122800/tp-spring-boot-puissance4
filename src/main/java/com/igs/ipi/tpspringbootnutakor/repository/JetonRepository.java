package com.igs.ipi.tpspringbootnutakor.repository;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.igs.ipi.tpspringbootnutakor.model.Jeton;

public interface JetonRepository extends PagingAndSortingRepository<Jeton, Serializable> {
	public Jeton findByGameIdAndXAndY(Integer id);
}