package com.memoria.fastmath.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoria.fastmath.model.MathFigure;
import com.memoria.fastmath.repository.MathFigureRepository;

@Service
public class MathFigureService {

	@Autowired
	private MathFigureRepository repository;
	
	public Optional<MathFigure> getMathFigureByID(Integer id) {
		return repository.findById(id); 
	}

	public Iterable<MathFigure> getMathFigureByFieldID(Integer id) {
		return repository.findByFieldID(id);
	}
	
	public Iterable<MathFigure> getAllMathFigures() {
		return repository.findAll();
	}
	
	public MathFigure saveMathFigure(MathFigure mathFigure) {
		return repository.save(mathFigure);
	}
	
	public void deleteMathFigureByID(Integer id) {
		repository.deleteById(id);
	}
}
