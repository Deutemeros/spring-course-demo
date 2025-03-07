package com.memoria.fastmath.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.memoria.fastmath.model.MathFigure;

@Repository
public interface MathFigureRepository extends CrudRepository<MathFigure, Integer>{

	@Query("FROM MathFigure WHERE field.id = ?1")
	public Iterable<MathFigure> findByFieldID(Integer id);
	
	@Query("FROM MathFigure WHERE field.id IN ?1")
	public Iterable<MathFigure> findByFieldIDs(List<Integer> ids);
	
}
