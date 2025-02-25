package com.memoria.fastmath.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoria.fastmath.model.Field;
import com.memoria.fastmath.model.MathFigure;
import com.memoria.fastmath.model.MathFigureInput;
import com.memoria.fastmath.repository.FieldRepository;
import com.memoria.fastmath.repository.MathFigureRepository;

@Service
public class MathFigureService {

	@Autowired
	private MathFigureRepository repository;
	
	@Autowired
	private FieldRepository fieldRepository;
	
	public Optional<MathFigure> getMathFigureByID(Integer id) {
		return repository.findById(id); 
	}

	public Iterable<MathFigure> getMathFiguresByFieldID(Integer id) {
		return repository.findByFieldID(id);
	}
	
	public Iterable<MathFigure> getMathFiguresByFieldIDs(List<Integer> ids) {
		return repository.findByFieldIDs(ids);
	}
	
	public Iterable<MathFigure> getAllMathFigures() {
		return repository.findAll();
	}
	
	public MathFigure saveMathFigure(MathFigureInput mathFigureInput) {
		MathFigure mathFigure = new MathFigure();
		mathFigure.setId(mathFigureInput.getId());
		mathFigure.setName(mathFigureInput.getName());
		mathFigure.setUrl(mathFigureInput.getUrl());
		mathFigure.setDescription(mathFigureInput.getDescription());
		Field field = fieldRepository.findById(mathFigureInput.getFieldId()).orElse(null);
		mathFigure.setField(field);
		return repository.save(mathFigure);
	}
	
	public void deleteMathFigureByID(Integer id) {
		repository.deleteById(id);
	}
	
}
