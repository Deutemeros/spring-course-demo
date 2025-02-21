package com.memoria.fastmath.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.memoria.fastmath.model.MathFigure;

@Repository
public interface MathFigureRepository extends CrudRepository<MathFigure, Integer>{

	public Iterable<MathFigure> findByFieldID(Integer id);
	
}
